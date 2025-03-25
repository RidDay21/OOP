package ru.nsu.laptev.task_2_3_1.controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.input.KeyCode;
import javafx.util.Duration;
import ru.nsu.laptev.task_2_3_1.model.SnakeModel;
import ru.nsu.laptev.task_2_3_1.view.SnakeView;

public class SnakeController {
    private final SnakeModel model;
    private final SnakeView view;
    private final Timeline timeline;

    public SnakeController(SnakeModel model, SnakeView view) {
        this.model = model;
        this.view = view;

        timeline = new Timeline(new KeyFrame(Duration.millis(150), e -> updateGame()));
        timeline.setCycleCount(Timeline.INDEFINITE);
    }

    public void startGame() {
        model.reset();
        timeline.play();
    }

    public void pauseGame() {
        timeline.stop();
    }

    private void updateGame() {
        model.update();
        view.render(model);

        if (!model.isRunning()) {
            timeline.stop();
        }
    }

    public void handleKey(KeyCode key) {
        if (!model.isRunning()) {
            if (key == KeyCode.DIGIT1) {
                startGame();
            }
            return;
        }

        String currentDirection = model.getDirection();
        switch (key) {
            case UP:
                if (!currentDirection.equals("DOWN")) {
                    model.setDirection("UP");
                }
                break;
            case DOWN:
                if (!currentDirection.equals("UP")) {
                    model.setDirection("DOWN");
                }
                break;
            case LEFT:
                if (!currentDirection.equals("RIGHT")) {
                    model.setDirection("LEFT");
                }
                break;
            case RIGHT:
                if (!currentDirection.equals("LEFT")) {
                    model.setDirection("RIGHT");
                }
                break;
        }
    }
}
