package dietaria.scenes;

import dietaria.models.login;
import dietaria.scenes.RegisterMenu1;
import dietaria.scenes.RegisterMenu3;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RegisterMenu2 {
    private Stage stage;
    private login log;

    public RegisterMenu2(Stage stage, login log) {
        this.stage = stage;
        this.log = log;
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

        TextField fullname = new TextField();
        fullname.setPromptText("Fullname");
        fullname.setEffect(dropShadow);
        fullname.getStyleClass().add("text-field");

        TextField phoneNumber = new TextField();
        phoneNumber.setPromptText("Nomor Handphone");
        phoneNumber.setEffect(dropShadow);
        phoneNumber.getStyleClass().add("text-field");

        TextField umur = new TextField();
        umur.setPromptText("Umur");
        umur.setEffect(dropShadow);
        umur.getStyleClass().add("text-field");

        VBox bio = new VBox(fullname, phoneNumber, umur);
        bio.setSpacing(10);
        bio.setAlignment(Pos.CENTER);
        bio.setPadding(new Insets(0, 0, 0, -45));

        TextField tinggi = new TextField();
        tinggi.setPromptText("Tinggi Badan");
        tinggi.setEffect(dropShadow);
        tinggi.getStyleClass().add("text-field2");

        TextField berat = new TextField();
        berat.setPromptText("Berat Badan");
        berat.setEffect(dropShadow);
        berat.getStyleClass().add("text-field2");

        HBox tinggiBerat = new HBox(tinggi, berat);

        Button cowok = new Button();
        ImageView cowo = new ImageView("/images/btnMale.png");
        ImageView ifCowo = new ImageView("/images/btnIfMale.png");
        cowok.setGraphic(cowo);
        cowok.setStyle("-fx-background-color: transparent; -fx-padding: 0;");

        Button cewek = new Button();
        ImageView cewe = new ImageView("/images/btnFemale.png");
        ImageView ifCewe = new ImageView("/images/btnIfFemale.png");
        cewek.setGraphic(cewe);
        cewek.setStyle("-fx-background-color: transparent; -fx-padding: 0;");

        cowok.setOnAction(e -> {
            cowok.setGraphic(ifCowo);
            cewek.setGraphic(cewe);
            log.setMale(true);
        });
        cewek.setOnAction(e -> {
            cowok.setGraphic(cowo);
            cewek.setGraphic(ifCewe);
            log.setMale(false);
        });

        HBox cowocewe = new HBox(cowok, cewek);
        cowocewe.setSpacing(10);
        cowocewe.setPadding(new Insets(0, 0, 0, 20));

        Button finish = new Button();
        ImageView buttonFinish = new ImageView("/images/btnFinish.png");
        finish.setGraphic(buttonFinish);
        finish.setStyle("-fx-background-color: transparent; -fx-padding: 0;");
        finish.setOnAction(e -> {
            if (!fullname.getText().isEmpty() && !phoneNumber.getText().isEmpty() && !umur.getText().isEmpty() && !tinggi.getText().isEmpty() && !berat.getText().isEmpty()) {
                log.setFullname(fullname.getText());
                log.setUmur(Integer.parseInt(umur.getText()));
                log.setBerat(Integer.parseInt(berat.getText()));
                log.setTinggi(Integer.parseInt(tinggi.getText()));
                
                RegisterMenu3 lanjut = new RegisterMenu3(stage, log);
                lanjut.show();
            }
        });

        Button back = new Button();
        ImageView buttonBack = new ImageView("/images/btnBack.png");
        back.setGraphic(buttonBack);
        back.setStyle("-fx-background-color: transparent; -fx-padding: 0;");
        back.setOnAction(e -> {
            RegisterMenu1 balik = new RegisterMenu1(stage);
            balik.show();
        });

        VBox button = new VBox(finish, back);
        button.setAlignment(Pos.BOTTOM_CENTER);
        button.setPadding(new Insets(0, 0, 30, -35));
        
        VBox vBox = new VBox(bio, tinggiBerat, cowocewe, button);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(50, 0, 0, 45));
        vBox.setSpacing(10);

        layout.getChildren().add(vBox);

        scene.getStylesheets().add("/style/TextFieldStyle.css");
        stage.setScene(scene);
        stage.show();
    }
}
