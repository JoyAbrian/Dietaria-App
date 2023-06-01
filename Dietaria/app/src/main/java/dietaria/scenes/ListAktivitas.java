package dietaria.scenes;

import dietaria.models.login;
import dietaria.models.makanan;
import dietaria.scenes.TambahMakanan;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ListAktivitas {
    private Stage stage;

    public ListAktivitas(Stage stage) {
        this.stage = stage;
    }
    
    public void show() {
        StackPane layout = new StackPane();
        Scene scene = new Scene(layout,340, 649);
        ImageView bg = new ImageView("/images/bgPilihAktivitas.png");
        layout.getChildren().add(bg);
        bg.setFitHeight(scene.getHeight());
        bg.setFitWidth(scene.getWidth());

        Button tambah = new Button();
        ImageView btnTambah = new ImageView("/images/btnAdd.png");
        tambah.setGraphic(btnTambah);
        tambah.setStyle("-fx-background-color: transparent; -fx-padding: 0;");
        tambah.setOnAction(e -> {
            TambahAktivitas tambahAktivitas = new TambahAktivitas(stage);
            tambahAktivitas.show();
        });

        VBox buttonTambah = new VBox(tambah);
        buttonTambah.setAlignment(Pos.BOTTOM_RIGHT);
        buttonTambah.setPadding(new Insets(0, 30, 30, 0));
        
        Button balik = new Button();
        ImageView btnBalik = new ImageView("/images/btnBalik.png");
        balik.setGraphic(btnBalik);
        balik.setStyle("-fx-background-color: transparent; -fx-padding: 0;");

        VBox buttonBalik = new VBox(balik);
        buttonBalik.setAlignment(Pos.TOP_LEFT);
        buttonBalik.setPadding(new Insets(35, 0, 0, 10));
        
        layout.getChildren().addAll(buttonBalik, buttonTambah);

        stage.setScene(scene);
        stage.show();

    }
}
