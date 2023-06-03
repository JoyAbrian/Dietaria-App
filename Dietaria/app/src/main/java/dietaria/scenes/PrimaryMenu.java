package dietaria.scenes;

import dietaria.models.aktivitas;
import dietaria.models.login;
import dietaria.models.makanan;
import dietaria.models.totalNutrisi;
import dietaria.utils.nutrisi;
import dietaria.utils.target;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class PrimaryMenu implements ShowMethod {
    private Stage stage;
    private login log;
    private makanan makan;
    private aktivitas aktivity;
    private static ObservableList<makanan> listSarapan = FXCollections.observableArrayList();
    private static ObservableList<makanan> listSiang = FXCollections.observableArrayList();
    private static ObservableList<makanan> listMalam = FXCollections.observableArrayList();
    private static ObservableList<makanan> listCemilan = FXCollections.observableArrayList();
    private static ObservableList<aktivitas> listAktivitas = FXCollections.observableArrayList();

    public static void addSarapan(makanan makanan){
        listSarapan.add(makanan);
    }
    
    public static void addSiang(makanan makanan){
        listSiang.add(makanan);
    }

    public static void addMalam(makanan makanan){
        listMalam.add(makanan);
    }
    
    public static void addCemilan(makanan makanan){
        listCemilan.add(makanan);
    }

    public static void addAktivitas(aktivitas aktivitas){
        listAktivitas.add(aktivitas);
    }

    public PrimaryMenu(Stage stage, login log) {
        this.stage = stage;
        this.log = log;
    }
    
    public PrimaryMenu(Stage stage, login log, makanan makan) {
        this.stage = stage;
        this.log = log;
        this.makan = makan;
    }

    public PrimaryMenu(Stage stage, login log, aktivitas aktivity) {
        this.stage = stage;
        this.log = log;
        this.aktivity = aktivity;
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
        welcum.setPadding(new Insets(0, 0, 0, 10));
        Label halo = new Label("Welcome, " + log.getFullname());
        halo.setFont(Font.font("BOOKMAN OLD STYLE", 25));
        halo.setAlignment(Pos.TOP_LEFT);
        halo.setPadding(new Insets(0, 0, 12, 0));
        welcum.getChildren().add(halo);

        totalNutrisi nutrisi = new totalNutrisi();

        StackPane kalori = new StackPane();
        ImageView budget = new ImageView("/images/LayerBudget.png");
        kalori.getChildren().add(budget);
        kalori.setOnMouseClicked(e -> {
            RincianNutrisi rincianNutrisi = new RincianNutrisi(stage, log, nutrisi);
            rincianNutrisi.show();
        });
        RincianNutrisi rincianNutrisi = new RincianNutrisi(stage, log, nutrisi);
        ProgressBar kaloripProgressBar = new ProgressBar(rincianNutrisi.hitungKalori());
        kaloripProgressBar.setStyle("-fx-pref-width: 200px; -fx-pref-height: 25px;");
        kalori.getChildren().add(kaloripProgressBar);


        VBox sarapan = new VBox();
        sarapan.setAlignment(Pos.CENTER);
        ImageView pagi = new ImageView("/images/LayerSarapan.png");
        sarapan.setOnMouseClicked(e -> {
            ListMakanan listMakanan = new ListMakanan(stage, log, "sarapan");
            listMakanan.show();
        });
        sarapan.getChildren().add(pagi);

        for (makanan m : listSarapan) {
            Label l = new Label(m.getNama());
            sarapan.getChildren().add(l);
        }

        VBox makanSiang = new VBox();
        ImageView siang = new ImageView("/images/LayerSiang.png");
        makanSiang.setOnMouseClicked(e -> {
            ListMakanan listMakanan = new ListMakanan(stage, log, "siang");
            listMakanan.show();
        });
        makanSiang.getChildren().add(siang);
        
        for (makanan m : listSiang) {
            Label l = new Label(m.getNama());
            makanSiang.getChildren().add(l);
        }

        VBox makanMalam = new VBox();
        ImageView malam = new ImageView("/images/LayerMalam.png");
        makanMalam.setOnMouseClicked(e -> {
            ListMakanan listMakanan = new ListMakanan(stage, log, "malam");
            listMakanan.show();
        });
        makanMalam.getChildren().add(malam);
        
        for (makanan m : listMalam) {
            Label l = new Label(m.getNama());
            makanMalam.getChildren().add(l);
        }

        VBox cemilan = new VBox();
        ImageView other = new ImageView("/images/LayerCemilan.png");
        cemilan.setOnMouseClicked(e -> {
            ListMakanan listMakanan = new ListMakanan(stage, log, "cemilan");
            listMakanan.show();
        });
        cemilan.getChildren().add(other);

        for (makanan m : listCemilan) {
            Label l = new Label(m.getNama());
            cemilan.getChildren().add(l);
        }

        VBox aktivitas = new VBox();
        ImageView active = new ImageView("/images/LayerAktivitas.png");
        aktivitas.setOnMouseClicked(e -> {
            ListAktivitas listAktivitas = new ListAktivitas(stage, log);
            listAktivitas.show();
        });
        aktivitas.getChildren().add(active);

        for (aktivitas m : listAktivitas) {
            Label l = new Label(m.getNama());
            aktivitas.getChildren().add(l);
        }

        Button logout = new Button();
        ImageView btnLogout = new ImageView("/images/btnLogout.png");
        logout.setGraphic(btnLogout);
        logout.setStyle("-fx-background-color: transparent; -fx-padding: 0;");
        logout.setOnAction(e -> {
            HomeScene homeScene = new HomeScene(stage);
            homeScene.show();
        });

        VBox listType = new VBox(sarapan, makanSiang, makanMalam, cemilan, aktivitas, logout);
        
        ScrollPane scrollPane = new ScrollPane(listType);
        scrollPane.setMaxWidth(500);
        scrollPane.setMinHeight(500);
        scrollPane.setStyle("-fx-background-color: transparent; -fx-background: transparent; -fx-border-color: transparent;");
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        
        BorderPane container = new BorderPane();
        container.setCenter(scrollPane);
        container.setPadding(new Insets(0, 0, 0, 40));
        
        VBox vBox = new VBox(welcum, kalori, container);
        vBox.setAlignment(Pos.TOP_CENTER);
        vBox.setPadding(new Insets(35, 0, 0, 0));
        layout.getChildren().add(vBox);
        
        stage.setScene(scene);
        stage.show();
    }
}
