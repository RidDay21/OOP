package ru.nsu.laptev.task_2_3_1.model;

import java.util.LinkedList;
import java.util.Random;

public class SnakeModel {
    public static final int TILE_SIZE = 20;
    public static final int WIDTH = 20;
    public static final int HEIGHT = 20;

    private LinkedList<int[]> snake;
    private int[] food;
    private String direction;
    private boolean running;

    public SnakeModel() {
        reset();
    }

    public void reset() {
        snake = new LinkedList<>();
        snake.add(new int[]{WIDTH / 2, HEIGHT / 2});
        food = new int[2];
        direction = "RIGHT";
        running = true;
        spawnFood();
    }

    public void update() {
        if (!running) return;

        // Клонируем голову
        int[] head = snake.getFirst().clone();

        switch (direction) {
            case "UP" -> head[1]--;
            case "DOWN" -> head[1]++;
            case "LEFT" -> head[0]--;
            case "RIGHT" -> head[0]++;
        }

        // Проверяем выход за границы или столкновение с собой
        if (head[0] < 0 || head[1] < 0 || head[0] >= WIDTH || head[1] >= HEIGHT ||
                snake.stream().anyMatch(s -> s[0] == head[0] && s[1] == head[1])) {
            running = false;
            return;
        }

        // Добавляем голову в начало списка
        snake.addFirst(head);

        // Проверяем, съели ли еду
        if (head[0] == food[0] && head[1] == food[1]) {
            spawnFood();
        } else {
            snake.removeLast();
        }
    }

    private void spawnFood() {
        Random random = new Random();
        food[0] = random.nextInt(WIDTH);
        food[1] = random.nextInt(HEIGHT);
    }

    // --- Геттеры / Сеттеры ---
    public LinkedList<int[]> getSnake() {
        return snake;
    }

    public int[] getFood() {
        return food;
    }

    public boolean isRunning() {
        return running;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
