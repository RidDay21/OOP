package ru.nsu.laptev;

import javafx.animation.AnimationTimer;

public class GameLoop {
    private AnimationTimer timer;
    private SnakeModel model;
    private long lastUpdate = 0;
    private double speedInterval;

    // Empty constructor, no premature access to model
    public GameLoop() {
        // Do nothing here that requires model
    }

    // Set the model and initialize the timer
    public void setModel(SnakeModel model) {
        this.model = model;
        this.speedInterval = model.getSpeedInterval(); // Safe to call now
        initializeTimer(); // Set up the timer after model is available
    }

    private void initializeTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (now - lastUpdate >= speedInterval * 1_000_000) {
                    if (model != null && model.isRunning()) {
                        model.update();
                    }
                    lastUpdate = now;
                }
            }
        };
    }

    public void start() {
        timer.start();
        System.out.println("Game loop started with interval: " + speedInterval + " ms");
    }

    public void pause() {
        timer.stop();
        System.out.println("Game loop paused");
    }

    public void updateSpeed(double newInterval) {
        if (newInterval >= 50) {
            speedInterval = newInterval;
            System.out.println("Speed updated, new interval: " + speedInterval + " ms");
        }
    }
}