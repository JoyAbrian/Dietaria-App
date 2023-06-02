package dietaria.scenes;

import dietaria.models.login;
import dietaria.models.makanan;
import dietaria.scenes.TambahMakanan;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ListMakanan {
    private Stage stage;
    private login log;

    public ListMakanan(Stage stage, login log) {
        this.stage = stage;
        this.log = log;
    }
    
    public void show() {
        StackPane layout = new StackPane();
        Scene scene = new Scene(layout,340, 649);
        ImageView bg = new ImageView("/images/bgPilihMakanan.png");
        layout.getChildren().add(bg);
        bg.setFitHeight(scene.getHeight());
        bg.setFitWidth(scene.getWidth());

        Button tambah = new Button();
        ImageView btnTambah = new ImageView("/images/btnAdd.png");
        tambah.setGraphic(btnTambah);
        tambah.setStyle("-fx-background-color: transparent; -fx-padding: 0;");
        tambah.setOnAction(e -> {
            TambahMakanan tambahMakanan = new TambahMakanan(stage, log);
            tambahMakanan.show();
        });

        VBox buttonTambah = new VBox(tambah);
        buttonTambah.setAlignment(Pos.BOTTOM_RIGHT);
        buttonTambah.setPadding(new Insets(0, 30, 30, 0));
        
        Button balik = new Button();
        ImageView btnBalik = new ImageView("/images/btnBalik.png");
        balik.setGraphic(btnBalik);
        balik.setStyle("-fx-background-color: transparent; -fx-padding: 0;");
        balik.setOnAction(e -> {
            PrimaryMenu primaryMenu = new PrimaryMenu(stage, log);
            primaryMenu.show();
        });

        VBox buttonBalik = new VBox(balik);
        buttonBalik.setAlignment(Pos.TOP_LEFT);
        buttonBalik.setPadding(new Insets(35, 0, 0, 10));

        VBox allBtn = new VBox(buttonBalik, buttonTambah);
        allBtn.setSpacing(420);
        layout.getChildren().add(allBtn);

        stage.setScene(scene);
        stage.show();

    }
}
