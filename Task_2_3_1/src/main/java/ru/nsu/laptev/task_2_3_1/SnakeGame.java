package ru.nsu.laptev.task_2_3_1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import ru.nsu.laptev.task_2_3_1.controller.SnakeController;
import ru.nsu.laptev.task_2_3_1.model.SnakeModel;
import ru.nsu.laptev.task_2_3_1.view.SnakeView;

public class SnakeGame extends Application {

    @Override
    public void start(Stage stage) {
        // --- Создаём Модель ---
        SnakeModel model = new SnakeModel();

        // --- Создаём Canvas и View ---
        Pane root = new Pane();
        Canvas canvas = new Canvas(
                SnakeModel.WIDTH * SnakeModel.TILE_SIZE,
                SnakeModel.HEIGHT * SnakeModel.TILE_SIZE
        );
        GraphicsContext gc = canvas.getGraphicsContext2D();
        SnakeView view = new SnakeView(gc);
        root.getChildren().add(canvas);

        // --- Создаём Controller ---
        SnakeController controller = new SnakeController(model, view);

        // --- Настраиваем сцену и обработку клавиш ---
        Scene scene = new Scene(root);
        scene.setOnKeyPressed(event -> {
            controller.handleKey(event.getCode());
        });

        stage.setTitle("Snake Game (MVC)");
        stage.setScene(scene);
        stage.show();

        // --- Запускаем игру ---
        controller.startGame();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
