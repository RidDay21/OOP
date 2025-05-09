package ru.nsu.laptev;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class SnakeView implements ModelObserver {
    private final GraphicsContext gc;
    private static final int GAME_WIDTH = SnakeModel.WIDTH * SnakeModel.TILE_SIZE; // 400
    private static final int SCORE_WIDTH = 200;
    private static final int FULL_WIDTH = GAME_WIDTH + SCORE_WIDTH; // 600
    private static final int HEIGHT = SnakeModel.HEIGHT * SnakeModel.TILE_SIZE; // 400

    public SnakeView(GraphicsContext gc) {
        this.gc = gc;
    }

    @Override
    public void onModelChanged(SnakeModel model) {
        if (!model.isRunning()) {
            renderGameOver(model.isWon());
        } else {
            renderGame(model);
            renderScore(model.getScore());
        }
    }

    private void renderGame(SnakeModel model) {
        // Очистка игровой области
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, GAME_WIDTH, HEIGHT);

        // Еда
        int[] food = model.getFood();
        gc.setFill(Color.RED);
        gc.fillRect(food[0] * SnakeModel.TILE_SIZE, food[1] * SnakeModel.TILE_SIZE,
                SnakeModel.TILE_SIZE, SnakeModel.TILE_SIZE);

        // Змейка
        gc.setFill(Color.WHITE);
        for (int[] part : model.getSnake()) {
            gc.fillRect(part[0] * SnakeModel.TILE_SIZE, part[1] * SnakeModel.TILE_SIZE,
                    SnakeModel.TILE_SIZE, SnakeModel.TILE_SIZE);
        }
    }

    private void renderScore(int score) {
        // Очистка области счета
        gc.setFill(Color.BLACK);
        gc.fillRect(GAME_WIDTH, 0, SCORE_WIDTH, HEIGHT);

        // Красная полоска слева от области счета
        gc.setStroke(Color.RED);
        gc.setLineWidth(2);
        gc.strokeLine(GAME_WIDTH, 0, GAME_WIDTH, HEIGHT);

        // Текст "Score: [число]" по центру
        gc.setFill(Color.WHITE);
        gc.setFont(Font.font(20));
        String scoreText = "Score: " + score;

        // Вычисление ширины текста для центрирования
        Text tempText = new Text(scoreText);
        tempText.setFont(gc.getFont());
        double textWidth = tempText.getLayoutBounds().getWidth();

        // Центрирование текста по горизонтали
        double textX = GAME_WIDTH + (SCORE_WIDTH - textWidth) / 2;
        double textY = 30; // Фиксированная высота

        gc.fillText(scoreText, textX, textY);
    }

    private void renderGameOver(boolean won) {
        boolean flag = false;
        Color color_of_title = Color.RED;
        if (won) {
            flag = true;
            color_of_title = Color.GREEN;
        }

        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, FULL_WIDTH, HEIGHT);

        gc.setFill(color_of_title);
        gc.setFont(Font.font(50));
        String gameOverText = "GAME OVER";
        Text tempGameOver = new Text(gameOverText);
        tempGameOver.setFont(gc.getFont());
        double gameOverWidth = tempGameOver.getLayoutBounds().getWidth();
        gc.fillText(gameOverText, (FULL_WIDTH - gameOverWidth) / 2, HEIGHT / 2 - 50);

        if (flag) {
            gc.setFill(Color.GREEN);
            gc.setFont(Font.font(30));
            String youWinText = "You win";
            Text tempYouWin = new Text(youWinText);
            tempYouWin.setFont(gc.getFont());
            double youWinWidth = tempYouWin.getLayoutBounds().getWidth();
            gc.fillText(youWinText, (FULL_WIDTH - youWinWidth) / 2, HEIGHT / 2);
        }

        // "Press 1 to restart SnakeGame"
        gc.setFill(Color.WHITE);
        gc.setFont(Font.font(20));
        String restartText = "Press 1 to restart SnakeGame";
        Text tempRestart = new Text(restartText);
        tempRestart.setFont(gc.getFont());
        double restartWidth = tempRestart.getLayoutBounds().getWidth();
        gc.fillText(restartText, (FULL_WIDTH - restartWidth) / 2, HEIGHT / 2 + 50);
    }
}