package dietaria.scenes;

import dietaria.models.login;
import dietaria.utils.nutrisi;
import dietaria.utils.target;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class PrimaryMenu {
    private Stage stage;
    private login log;

    public PrimaryMenu(Stage stage, login log) {
        this.stage = stage;
        this.log = log;
    }

    public void show() {
        StackPane layout = new StackPane();
        Scene scene = new Scene(layout,340, 649);
        ImageView bg = new ImageView("/images/bgPrimary.png");
        layout.getChildren().add(bg);
        bg.setFitWidth(scene.getWidth());
        bg.setFitHeight(scene.getHeight());

        StackPane welcum = new StackPane();
        ImageView welcome = new ImageView("/images/LayerWelcome.png");
        welcum.getChildren().add(welcome);

        StackPane kalori = new StackPane();
        ImageView budget = new ImageView("/images/LayerBudget.png");
        kalori.getChildren().add(budget);

        StackPane sarapan = new StackPane();
        ImageView pagi = new ImageView("/images/LayerSarapan.png");
        sarapan.setOnMouseClicked(e -> {
            ListMakanan listMakanan = new ListMakanan(stage, log);
            listMakanan.show();
        });
        sarapan.getChildren().add(pagi);
        
        StackPane makanSiang = new StackPane();
        ImageView siang = new ImageView("/images/LayerSiang.png");
        makanSiang.setOnMouseClicked(e -> {
            ListMakanan listMakanan = new ListMakanan(stage, log);
            listMakanan.show();
        });
        makanSiang.getChildren().add(siang);
        
        StackPane makanMalam = new StackPane();
        ImageView malam = new ImageView("/images/LayerMalam.png");
        makanMalam.setOnMouseClicked(e -> {
            ListMakanan listMakanan = new ListMakanan(stage, log);
            listMakanan.show();
        });
        makanMalam.getChildren().add(malam);
        
        StackPane cemilan = new StackPane();
        ImageView other = new ImageView("/images/LayerCemilan.png");
        cemilan.setOnMouseClicked(e -> {
            ListMakanan listMakanan = new ListMakanan(stage, log);
            listMakanan.show();
        });
        cemilan.getChildren().add(other);

        StackPane aktivitas = new StackPane();
        ImageView active = new ImageView("/images/LayerAktivitas.png");
        aktivitas.setOnMouseClicked(e -> {
            ListAktivitas listAktivitas = new ListAktivitas(stage, log);
            listAktivitas.show();
        });
        aktivitas.getChildren().add(active);

        Button logout = new Button();
        ImageView btnLogout = new ImageView("/images/btnLogout.png");
        logout.setGraphic(btnLogout);
        logout.setStyle("-fx-background-color: transparent; -fx-padding: 0;");
        logout.setOnAction(e -> {
            HomeScene homeScene = new HomeScene(stage);
            homeScene.show();
        });

        VBox vBox = new VBox(welcum, kalori, sarapan, makanSiang, makanMalam, cemilan, aktivitas, logout);
        vBox.setAlignment(Pos.CENTER);
        layout.getChildren().add(vBox);

        stage.setScene(scene);
        stage.show();
    }
}
