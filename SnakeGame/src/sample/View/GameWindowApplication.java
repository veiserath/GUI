package sample.View;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import sample.Model.GameTime;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameWindowApplication extends Application {

    private enum Direction {
        UP, DOWN, LEFT, RIGHT
    }

    private ArrayList<KeyCode> keysDown = new ArrayList<KeyCode>();
    private List<SnakeSegment> snake = new ArrayList<>();

    private Stage primaryStage;
    private Scene scene;
    private AnimationTimer animationTimer;
    private GameTime gameTime;
    private GraphicsContext graphicsContext;
    private Random random;
    private Canvas canvas;

    private Direction direction = Direction.RIGHT;

    private int speed = 5;
    private int foodColor = 0;
    private int height;
    private int width;
    private int foodX = 0;
    private int foodY = 0;
    private int cornerSize = 25;
    private int score = 0;
    private boolean gameOver;
    private boolean specialUpgradeFood;

    public GameWindowApplication(int width, int height) {
        this.width = width;
        this.height = height;
        random = new Random();
    }

    public static class SnakeSegment {
        int x;
        int y;

        public SnakeSegment(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        newFood();
        gameTime = new GameTime();
        gameTime.start();


        VBox root = new VBox();
//        all dimensions will be later calculated in terms of "corners"
        canvas = new Canvas(width * cornerSize, height * cornerSize);
        this.graphicsContext = canvas.getGraphicsContext2D();
        this.scene = new Scene(root, cornerSize * width, cornerSize * height);
        root.getChildren().add(canvas);


        this.animationTimer = new AnimationTimer() {

            long lastUpdate = 0;

            @Override
            public void handle(long now) {
                long timeToNextAnimation = 1_000_000_000L / speed;
                long elapsedTime = now - lastUpdate;
//                increase in speed means decrease in timeToNextAnimation means increase in FPS
                if (elapsedTime >= timeToNextAnimation) {
                    gameLoop();
                    lastUpdate = now;
                }
            }
        };


        animationTimer.start();

        quitShortcut();
        snakeControls();

        snake.add(new SnakeSegment(width / 2, height / 2));

        primaryStage.setScene(scene);
        primaryStage.setTitle("Snake Game");
        primaryStage.show();


    }

    public static void main(String[] args) {
        launch(args);
    }

    public void gameLoop() {


        growSnake();
        wallHitCheck();
        eatFood();
        selfDestruct();
        fillBackground();
        displayScore();
        displayTime();
        randomFoodColor();
        snakeLook();
        wholeMapFillCheck();
        setGameOverMessage();


    }

    public void newFood() {

        foodX = random.nextInt(width);
        foodY = random.nextInt(height);

        foodColor = random.nextInt(10);
        specialFoodTrigger();

    }


    public void setGameOver() {

        gameOver = true;
        animationTimer.stop();
        GameOverApplication gameOverApplication = new GameOverApplication(gameTime, score, width, height);
        try {
            gameOverApplication.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void quitShortcut() {

        scene.setOnKeyPressed(event -> {
            if (!keysDown.contains(event.getCode())) {
                keysDown.add(event.getCode());
            }
            if (keysDown.contains(KeyCode.O) && keysDown.contains(KeyCode.SHIFT) && keysDown.contains(KeyCode.CONTROL)) {
                MainMenuApplication mainMenuApplication = new MainMenuApplication();
                mainMenuApplication.start(primaryStage);
            }
        });
        scene.setOnKeyReleased(event ->
                keysDown.remove(event.getCode())
        );
    }

    public void eatFood() {

        if (foodX == snake.get(0).x && foodY == snake.get(0).y && !specialUpgradeFood) {
            snake.add(new SnakeSegment(-1, -1));
            newFood();
            score++;
            speed++;
        } else if (foodX == snake.get(0).x && foodY == snake.get(0).y && specialUpgradeFood && snake.size() > 1) {
            snake.remove(snake.size() - 1);
            newFood();
            score++;
            speed--;
        } else if (foodX == snake.get(0).x && foodY == snake.get(0).y && specialUpgradeFood) {
            newFood();
            score++;
        }
    }

    public void displayScore() {

        graphicsContext.setFill(Color.WHITE);
        graphicsContext.setFont(new Font("", 30));
        graphicsContext.fillText("Score: " + score, 10, 30);
    }

    public void displayTime() {

        graphicsContext.setFill(Color.WHITE);
        graphicsContext.setFont(new Font("", 30));
        graphicsContext.fillText("Time: " + gameTime.getMinutes() + " : " + gameTime.getSeconds(), 200, 30);
    }

    public void fillBackground() {

        graphicsContext.setFill(Color.BLACK);
        graphicsContext.fillRect(0, 0, width * cornerSize, width * cornerSize);
    }

    public void selfDestruct() {

        for (int i = 1; i < snake.size(); i++) {
            if (snake.get(0).x == snake.get(i).x && snake.get(0).y == snake.get(i).y) {
                setGameOver();
            }
        }
    }
    
    public void setGameOverMessage() {

        if (gameOver) {
            System.out.println("Game is over");
            graphicsContext.setFill(Color.RED);
            graphicsContext.setFont(new Font("", 50));
            graphicsContext.setTextAlign(TextAlignment.CENTER);
            graphicsContext.fillText("Game over", canvas.getWidth() / 2, canvas.getHeight() / 2);
        }


    }

    public void snakeLook() {

        for (SnakeSegment snakeSegment : snake) {
//            these two colors combined make a shadow - wow!
            graphicsContext.setFill(Color.LIGHTGREEN);
            graphicsContext.fillRect(snakeSegment.x * cornerSize, snakeSegment.y * cornerSize, cornerSize - 1, cornerSize - 1);
            graphicsContext.setFill(Color.GREEN);
            graphicsContext.fillRect(snakeSegment.x * cornerSize, snakeSegment.y * cornerSize, cornerSize - 2, cornerSize - 2);
        }
    }

    public void randomFoodColor() {

        if (specialUpgradeFood) {
            foodColor = random.nextInt(9);
        }
        Color randomFoodColor;

        switch (foodColor) {
            case 0:
                randomFoodColor = Color.PURPLE;
                break;
            case 1:
                randomFoodColor = Color.LIGHTBLUE;
                break;
            case 2:
                randomFoodColor = Color.YELLOW;
                break;
            case 3:
                randomFoodColor = Color.PINK;
                break;
            case 4:
                randomFoodColor = Color.ORANGE;
                break;
            case 5:
                randomFoodColor = Color.MAGENTA;
                break;
            case 6:
                randomFoodColor = Color.BLUE;
                break;
            case 7:
                randomFoodColor = Color.BROWN;
                break;
            case 8:
                randomFoodColor = Color.GREEN;
                break;
            default:
                randomFoodColor = Color.WHITE;
        }
        graphicsContext.setFill(randomFoodColor);
        graphicsContext.fillOval(foodX * cornerSize, foodY * cornerSize, cornerSize, cornerSize);
    }


    public void snakeControls() {

        scene.addEventFilter(KeyEvent.KEY_PRESSED, key -> {
            if (key.getCode() == KeyCode.W) {
                direction = Direction.UP;
            }
            if (key.getCode() == KeyCode.S) {
                direction = Direction.DOWN;
            }
            if (key.getCode() == KeyCode.D) {
                direction = Direction.RIGHT;
            }
            if (key.getCode() == KeyCode.A) {
                direction = Direction.LEFT;
            }
        });
    }

    public void growSnake() {

        for (int i = snake.size() - 1; i >= 1; i--) {
//            make another identical snakeSegment
            snake.get(i).x = snake.get(i - 1).x;
            snake.get(i).y = snake.get(i - 1).y;
        }
    }

    public void wallHitCheck() {

        switch (direction) {
            case UP:
                snake.get(0).y--;
                if (snake.get(0).y < 0) {
                    setGameOver();
                }
                break;
            case DOWN:
                snake.get(0).y++;
                if (snake.get(0).y > height) {
                    setGameOver();
                }
                break;
            case RIGHT:
                snake.get(0).x++;
                if (snake.get(0).x > width) {
                    setGameOver();
                }
                break;
            case LEFT:
                snake.get(0).x--;
                if (snake.get(0).x < 0) {
                    setGameOver();
                }
                break;
        }
    }

    public void wholeMapFillCheck() {
        if (width * height == snake.size()) {
            setGameOver();
        }
    }

    public void specialFoodTrigger() {
        if (foodColor == 9) {
            specialUpgradeFood = true;
            speed--;
        } else {
            specialUpgradeFood = false;
        }
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
