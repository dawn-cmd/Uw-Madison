import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.application.Platform;
import javafx.geometry.Pos;
import java.util.Random;

public class DessertGame extends Application {
    private int score = 0;
    
    @Override
    public void start(final Stage stage) {
        BorderPane borderPane = new BorderPane();
        Scene scene = new Scene(borderPane, 640, 480);
        stage.setTitle("Dessert in the Desert JavaFX Game");
        
        Label scoreLabel = new Label("Score: 0");
        borderPane.setTop(scoreLabel);
        BorderPane.setAlignment(scoreLabel, Pos.TOP_LEFT);
        
        Button exitButton = new Button("Exit");
        exitButton.setOnAction(event -> {
            Platform.exit();
        });
        borderPane.setBottom(exitButton);
        BorderPane.setAlignment(exitButton, Pos.BOTTOM_RIGHT);
        
        Pane pane = new Pane();
        borderPane.setCenter(pane);
        BorderPane.setAlignment(pane, Pos.CENTER);
        
        Button dessertButton = new Button("Dessert");
        dessertButton.setOnAction(event -> {
            incrementScore();
            scoreLabel.setText("Score: " + score);
            randomizeButtonPositions(pane);
            exitButton.requestFocus();
        });
        
        Button[] desertButtons = new Button[7];
        for (int i = 0; i < 7; i++) {
            desertButtons[i] = new Button("Desert");
            desertButtons[i].setOnAction(event -> {
                decrementScore();
                scoreLabel.setText("Score: " + score);
                randomizeButtonPositions(pane);
                exitButton.requestFocus();
            });
            pane.getChildren().add(desertButtons[i]);
        }
        
        pane.getChildren().add(dessertButton);
        
        randomizeButtonPositions(pane);
        
        stage.setScene(scene);
        stage.show();
    }
    
    private void incrementScore() {
        score++;
    }
    
    private void decrementScore() {
        score--;
    }
    
    private void randomizeButtonPositions(Pane pane) {
        Random random = new Random();
        
        for (javafx.scene.Node node : pane.getChildren()) {
            if (node instanceof Button) {
                Button button = (Button) node;
                button.setLayoutX(random.nextInt(601));
                button.setLayoutY(random.nextInt(401));
            }
        }
    }
    
    public static void main(String[] args) {
        Application.launch();
    }
}
