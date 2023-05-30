package dietaria.scenes;

import dietaria.dao.loginDao;
import dietaria.models.login;
import dietaria.scenes.HomeScene;
import dietaria.scenes.RegisterMenu2;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class RegisterMenu1 {
    private Stage stage;

    public RegisterMenu1(Stage stage) {
        this.stage = stage;
    }

    public void show() {
        StackPane layout = new StackPane();
        Scene scene = new Scene(layout,340, 649);
        ImageView bg = new ImageView("/images/bgRegister.png");
        layout.getChildren().add(bg);
        bg.setFitHeight(scene.getHeight());
        bg.setFitWidth(scene.getWidth());
        
        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(2);
        dropShadow.setOffsetY(2);
        dropShadow.setColor(javafx.scene.paint.Color.GRAY);

        Label usernameLabel = new Label("Username");
        usernameLabel.setFont(Font.font("Bitter", 15));
        TextField username = new TextField();
        username.setPromptText("Masukkan username anda...");
        username.setEffect(dropShadow);
        username.getStyleClass().add("text-field");
        VBox vBoxNama = new VBox(usernameLabel, username);
        vBoxNama.setSpacing(5);
        vBoxNama.setPadding(new Insets(0, 0, 0, 45));
        
        Label passwordLabel = new Label("Password");
        passwordLabel.setFont(Font.font("Bitter", 15));
        TextField password = new TextField();
        password.setPromptText("Masukkan password anda...");
        password.setEffect(dropShadow);
        password.getStyleClass().add("text-field");
        VBox vBoxPassword = new VBox(passwordLabel, password);
        vBoxPassword.setSpacing(5);
        vBoxPassword.setPadding(new Insets(0, 0, 0, 45));

        VBox vBox = new VBox(vBoxNama, vBoxPassword);
        vBox.setSpacing(20);

        Button lanjut = new Button();
        ImageView buttonLanjut = new ImageView("/images/btnNext.png");
        lanjut.setGraphic(buttonLanjut);
        lanjut.setStyle("-fx-background-color: transparent; -fx-padding: 0;");
        lanjut.setOnAction(e -> {
            if (!username.getText().isEmpty() && !password.getText().isEmpty()) {
                // loginDao dao = new loginDao();
                // dao.saveUser(new login(null, null, null, false, 0, 0, 0));
                login log = new login();
                log.setUsername(username.getText());
                log.setPassword(password.getText());
                RegisterMenu2 lanjutan = new RegisterMenu2(stage, log);
                lanjutan.show();
            }
        });

        Button balik = new Button();
        ImageView buttonBalik = new ImageView("/images/btnBack.png");
        balik.setGraphic(buttonBalik);
        balik.setStyle("-fx-background-color: transparent; -fx-padding: 0;");
        balik.setOnAction(e -> {
            HomeScene home = new HomeScene(stage);
            home.show();
        });
        VBox button = new VBox(lanjut, balik);
        button.setAlignment(Pos.BOTTOM_CENTER);
        button.setPadding(new Insets(0, 0, 30, 0));

        VBox vBox1 = new VBox(vBox, button);
        vBox1.setSpacing(30);
        vBox1.setAlignment(Pos.CENTER);
        layout.getChildren().add(vBox1);

        scene.getStylesheets().add("/style/TextFieldStyle.css");
        stage.setScene(scene);
        stage.show();
    }
}