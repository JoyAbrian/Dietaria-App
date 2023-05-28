package dietaria.scenes;

import dietaria.scenes.RegisterMenu1;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HomeScene {
    private Stage stage;
    
    public HomeScene(Stage stage) {
        this.stage = stage;
    }

    public void show() {
        StackPane layout = new StackPane();
        Scene scene = new Scene(layout,340, 649);
        ImageView bg = new ImageView("/images/bgHome.png");
        layout.getChildren().add(bg);
        bg.setFitHeight(scene.getHeight());
        bg.setFitWidth(scene.getWidth());

        Button logo = new Button();
        ImageView dietaria = new ImageView("/images/DietariaLogo1.png");
        logo.setGraphic(dietaria);
        HBox hBox = new HBox(logo);
        hBox.setAlignment(Pos.TOP_CENTER);
        logo.setStyle("-fx-background-color: transparent; -fx-padding: 0;");
        layout.getChildren().add(hBox);
        
        ImageView register = new ImageView("/images/btnRegister.png"); 
        Button btnRegister = new Button();
        btnRegister.setGraphic(register);
        btnRegister.setStyle("-fx-background-color: transparent; -fx-padding: 0;");
        btnRegister.setPrefSize(200, 25);
        btnRegister.setOnAction(e -> {
            RegisterMenu1 daftar = new RegisterMenu1(stage);
            daftar.show();
        });

        ImageView login = new ImageView("/images/btnLogin.png"); 
        Button btnLogin = new Button();
        btnLogin.setGraphic(login);
        btnLogin.setStyle("-fx-background-color: transparent; -fx-padding: 0;");
        btnLogin.setPrefSize(200, 60);

        VBox homeButton = new VBox(btnRegister, btnLogin);
        homeButton.setSpacing(15);
        homeButton.setAlignment(Pos.BOTTOM_CENTER);
        layout.getChildren().add(homeButton);
        StackPane.setMargin(homeButton, new Insets(0, 0, 50, 0));

        stage.setScene(scene);
        stage.show();
    }
}