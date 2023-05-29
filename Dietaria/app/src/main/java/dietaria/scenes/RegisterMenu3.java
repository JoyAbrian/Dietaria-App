package dietaria.scenes;

import dietaria.scenes.LoginMenu;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RegisterMenu3 {
    private Stage stage;

    public RegisterMenu3(Stage stage) {
        this.stage = stage;
    }

    public void show() {
        StackPane layout = new StackPane();
        Scene scene = new Scene(layout,340, 649);
        ImageView bg = new ImageView("/images/bgRegister2.png");
        layout.getChildren().add(bg);
        bg.setFitHeight(scene.getHeight());
        bg.setFitWidth(scene.getWidth());

        Button toLogin = new Button();
        ImageView login = new ImageView("/images/btnToLogin.png");
        toLogin.setGraphic(login);;
        toLogin.setStyle("-fx-background-color: transparent; -fx-padding: 0;");
        toLogin.setOnAction(e -> {
            LoginMenu masuk = new LoginMenu(stage);
            masuk.show();
        });

        VBox vBox = new VBox(toLogin);
        vBox.setAlignment(Pos.BOTTOM_CENTER);
        vBox.setPadding(new Insets(0, 0, 200, 10));
        layout.getChildren().add(vBox);

        stage.setScene(scene);
        stage.show();
    }
}
