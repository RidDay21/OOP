package ru.nsu.laptev;

import javafx.scene.input.KeyCode;

public class SnakeController {
    private final SnakeModel model;

    public SnakeController(SnakeModel model) {
        this.model = model;
    }

    public void handleKey(KeyCode code) {
        switch (code) {
            case UP:
                model.setDirectionIfValid("UP", "DOWN");
                break;
            case DOWN:
                model.setDirectionIfValid("DOWN", "UP");
                break;
            case LEFT:
                model.setDirectionIfValid("LEFT", "RIGHT");
                break;
            case RIGHT:
                model.setDirectionIfValid("RIGHT", "LEFT");
                break;
            case DIGIT1:
                if (!model.isRunning()) {
                    model.reset(); // Перезапуск игры
                }
                break;
        }
    }
}