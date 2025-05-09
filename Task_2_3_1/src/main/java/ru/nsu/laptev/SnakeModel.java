package ru.nsu.laptev;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class SnakeModel {
    public static final int TILE_SIZE = 20;
    public static final int WIDTH = 20;
    public static final int HEIGHT = 20;
    public static final int WIN_SCORE = 50; // Условие победы: 150 очков

    private final List<ModelObserver> observers = new ArrayList<>();
    private LinkedList<int[]> snake;
    private int[] food;
    private int score;
    private String direction;
    private boolean running;
    private boolean won;
    private double speedInterval = 400;
    private GameLoop gameLoop;

    public SnakeModel(GameLoop gameLoop) {
        this.gameLoop = gameLoop;
        reset();
    }

    public void reset() {
        snake = new LinkedList<>();
        snake.add(new int[]{WIDTH / 2, HEIGHT / 2});
        food = new int[2];
        score = 0;
        direction = "RIGHT";
        running = true;
        won = false; // Сбрасываем флаг победы
        speedInterval = 200;
        if (gameLoop != null) {
            gameLoop.updateSpeed(speedInterval);
        }
        spawnFood();
        notifyObservers();
    }

    public void update() {
        if (!running) return;

        int[] head = snake.getFirst().clone();

        switch (direction) {
            case "UP" -> head[1]--;
            case "DOWN" -> head[1]++;
            case "LEFT" -> head[0]--;
            case "RIGHT" -> head[0]++;
        }

        if (head[0] < 0 || head[1] < 0 || head[0] >= WIDTH || head[1] >= HEIGHT ||
                snake.stream().anyMatch(s -> s[0] == head[0] && s[1] == head[1])) {
            running = false;
            won = false; // Поражение
            notifyObservers();
            return;
        }

        snake.addFirst(head);

        if (head[0] == food[0] && head[1] == food[1]) {
            score += 10;
            if (score >= WIN_SCORE) {
                running = false;
                won = true; // Победа
                notifyObservers();
                return;
            }
            speedInterval = Math.max(50, speedInterval - 10);
            if (gameLoop != null) {
                gameLoop.updateSpeed(speedInterval);
            }
            spawnFood();
        } else {
            snake.removeLast();
        }

        notifyObservers();
    }

    private void spawnFood() {
        Random random = new Random();
        food[0] = random.nextInt(WIDTH);
        food[1] = random.nextInt(HEIGHT);
    }

    public void addObserver(ModelObserver observer) {
        observers.add(observer);
    }

    private void notifyObservers() {
        for (ModelObserver observer : observers) {
            observer.onModelChanged(this);
        }
    }

    // Геттеры
    public LinkedList<int[]> getSnake() { return snake; }
    public int[] getFood() { return food; }
    public int getScore() { return score; }
    public boolean isRunning() { return running; }
    public String getDirection() { return direction; }
    public double getSpeedInterval() { return speedInterval; }
    public boolean isWon() { return won; } // Новый геттер для проверки победы

    public void setDirectionIfValid(String newDir, String forbiddenDir) {
        if (!direction.equals(forbiddenDir)) {
            direction = newDir;
        }
    }
}