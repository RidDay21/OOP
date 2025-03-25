package ru.nsu.laptev.task_2_3_1.view;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import ru.nsu.laptev.task_2_3_1.model.SnakeModel;

public class SnakeView {
    private final GraphicsContext gc;

    public SnakeView(GraphicsContext gc) {
        this.gc = gc;
    }

    public void render(SnakeModel model) {
        // Заливка фона
        gc.setFill(Color.BLACK);
        gc.fillRect(
                0, 0,
                SnakeModel.WIDTH * SnakeModel.TILE_SIZE,
                SnakeModel.HEIGHT * SnakeModel.TILE_SIZE
        );

        // Рисуем еду
        gc.setFill(Color.RED);
        int[] food = model.getFood();
        gc.fillOval(
                food[0] * SnakeModel.TILE_SIZE,
                food[1] * SnakeModel.TILE_SIZE,
                SnakeModel.TILE_SIZE,
                SnakeModel.TILE_SIZE
        );

        // Рисуем змейку
        gc.setFill(Color.GREEN);
        for (int[] part : model.getSnake()) {
            gc.fillRect(
                    part[0] * SnakeModel.TILE_SIZE,
                    part[1] * SnakeModel.TILE_SIZE,
                    SnakeModel.TILE_SIZE,
                    SnakeModel.TILE_SIZE
            );
        }
    }
}
