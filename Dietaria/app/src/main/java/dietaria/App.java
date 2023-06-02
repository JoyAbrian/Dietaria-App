package dietaria;

import dietaria.scenes.HomeScene;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Dietaria");
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image("/images/icon.png"));
        
        HomeScene homeScene = new HomeScene(primaryStage);
        homeScene.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}