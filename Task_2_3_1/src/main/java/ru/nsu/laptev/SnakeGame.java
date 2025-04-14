package ru.nsu.laptev;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SnakeGame extends Application {
    private enum GameState { START, RUNNING, GAME_OVER }
    private GameState currentState = GameState.START;
    private Canvas canvas;
    private StackPane root;
    private StackPane startOverlay;

    @Override
    public void start(Stage stage) {
        GameLoop loop = new GameLoop();
        SnakeModel model = new SnakeModel(loop);
        loop.setModel(model);

        canvas = new Canvas(600, 400); // Один холст 600x400

        SnakeView view = new SnakeView(canvas.getGraphicsContext2D());
        SnakeController controller = new SnakeController(model);

        model.addObserver(view);

        root = new StackPane(canvas);
        root.setStyle("-fx-background-color: black;");

        Text startText = new Text("Нажмите ENTER для старта");
        startText.setFont(Font.font(24));
        startText.setFill(Color.WHITE);
        startOverlay = new StackPane(startText);
        startOverlay.setStyle("-fx-background-color: rgba(34,0,4,0.7);");
        root.getChildren().add(startOverlay);

        Scene scene = new Scene(root);
        scene.setFill(Color.BLACK);

        scene.setOnKeyPressed(event -> {
            if (currentState == GameState.START && event.getCode() == KeyCode.ENTER) {
                root.getChildren().remove(startOverlay);
                currentState = GameState.RUNNING;
                loop.start();
            }
            controller.handleKey(event.getCode());
        });

        stage.setTitle("Snake Game");
        stage.setScene(scene);
        stage.setWidth(660); // Учитываем рамки
        stage.setHeight(440);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}