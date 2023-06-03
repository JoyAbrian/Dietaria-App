package dietaria.scenes;

import java.util.ArrayList;
import java.util.HashMap;

import dietaria.dao.makananDao;
import dietaria.models.login;
import dietaria.models.makanan;
import dietaria.models.totalNutrisi;
import dietaria.scenes.TambahMakanan;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ListMakanan implements ShowMethod {
    private Stage stage;
    private login log;
    private String type;
    private makanan makananPilihan;
    private totalNutrisi total;

    public ListMakanan(Stage stage, login log, String type, totalNutrisi total) {
        this.stage = stage;
        this.log = log;
        this.type = type;
        this.total = total;
    }
    
    public void show() {
        StackPane layout = new StackPane();
        Scene scene = new Scene(layout,340, 649);
        ImageView bg = new ImageView("/images/bgPilihMakanan.png");
        layout.getChildren().add(bg);
        bg.setFitHeight(scene.getHeight());
        bg.setFitWidth(scene.getWidth());

        Button tambah = new  Button();
        ImageView btnTambah = new ImageView("/images/btnAdd.png");
        tambah.setGraphic(btnTambah);
        tambah.setStyle("-fx-background-color: transparent; -fx-padding: 0;");
        tambah.setOnAction(e -> {
            TambahMakanan tambahMakanan = new TambahMakanan(stage, log, type, total);
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
            PrimaryMenu primaryMenu = new PrimaryMenu(stage, log, total);
            primaryMenu.show();
        });

        VBox buttonBalik = new VBox(balik);
        buttonBalik.setAlignment(Pos.TOP_LEFT);
        buttonBalik.setPadding(new Insets(35, 0, 0, 10));

        VBox food = new VBox();
        ArrayList<makanan> makananList = makananDao.getAllMakanan();
        
        for (makanan makan : makananList) {
            StackPane stackPane = new StackPane();
        
            ImageView layer = new ImageView("/images/layerListMakanan.png");
        
            stackPane.getChildren().add(layer);
        
            Label foodName = new Label(makan.getNama());
            foodName.setFont(Font.font("GEORGIA", 20));
            foodName.setTextFill(Color.WHITE);

            HBox composContainer = new HBox(10);
            HashMap<String, String> attributes = makan.toHashMap();
        
            attributes.forEach((attrName, value) -> {
                Label compositionName = new Label(attrName);
                compositionName.setFont(Font.font("CHARLEMAGNE STD BOLD", 15));
                compositionName.setTextFill(Color.WHITE);    
                Label compositionValue = new Label(value);
                compositionValue.setFont(Font.font("CHARLEMAGNE STD BOLD", 15));
                compositionValue.setTextFill(Color.WHITE);    
                composContainer.getChildren().add(new VBox(compositionName, compositionValue));
            });
        
            VBox isi = new VBox(10, foodName, composContainer);
            isi.setPadding(new Insets(10, 0, 0, 10));
            isi.setOnMouseClicked(e -> {
                if (type == "sarapan") {
                    PrimaryMenu.addSarapan(makan);
                    makananPilihan = makan;
                } else if (type == "siang") {
                    PrimaryMenu.addSiang(makan);
                    makananPilihan = makan;
                } else if (type == "malam") {
                    PrimaryMenu.addMalam(makan);
                    makananPilihan = makan;
                } else if (type == "cemilan") {
                    PrimaryMenu.addCemilan(makan);
                    makananPilihan = makan;
                }
                total.addMakanan(makan);
                PrimaryMenu primaryMenu = new PrimaryMenu(stage, log, makananPilihan, total);
                primaryMenu.show();
            });

            stackPane.getChildren().add(isi);
            food.getChildren().addAll(stackPane);
        }
        
        ScrollPane scrollPane = new ScrollPane(food);
        scrollPane.setMaxWidth(300);
        scrollPane.setMinHeight(400);
        scrollPane.setStyle("-fx-background-color: transparent; -fx-background: transparent; -fx-border-color: transparent;");
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        
        BorderPane container = new BorderPane();
        container.setCenter(scrollPane);
        container.setPadding(new Insets(50, 0, 0, 0));

        VBox everything = new VBox(buttonBalik, container, buttonTambah);
        layout.getChildren().add(everything);

        stage.setScene(scene);
        stage.show();
    }
}
