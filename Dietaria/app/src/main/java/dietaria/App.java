package dietaria;

import dietaria.scenes.HomeScene;
import dietaria.scenes.ListAktivitas;
import dietaria.scenes.ListMakanan;

import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Dietaria");
        primaryStage.setResizable(false);
        
        HomeScene homeScene = new HomeScene(primaryStage);
        homeScene.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}