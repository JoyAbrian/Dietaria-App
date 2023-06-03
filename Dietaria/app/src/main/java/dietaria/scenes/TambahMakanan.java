package dietaria.scenes;

import dietaria.dao.makananDao;
import dietaria.models.login;
import dietaria.models.makanan;
import dietaria.scenes.ListMakanan;

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

public class TambahMakanan {
    private Stage stage;
    private login log;
    private String type;

    public TambahMakanan(Stage stage, login log, String type) {
        this.stage = stage;
        this.log = log;
        this.type = type;
    }

    public void show() {
        StackPane layout = new StackPane();
        Scene scene = new Scene(layout,340, 649);
        ImageView bg = new ImageView("/images/bgTambahMakanan.png");
        layout.getChildren().add(bg);
        bg.setFitHeight(scene.getHeight());
        bg.setFitWidth(scene.getWidth());

        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(2);
        dropShadow.setOffsetY(2);
        dropShadow.setColor(javafx.scene.paint.Color.GRAY);

        TextField name = new TextField();
        name.setPromptText("Nama Makanan");
        name.setEffect(dropShadow);
        name.getStyleClass().add("text-field");

        TextField review = new TextField();
        review.setPromptText("Review Makanan");
        review.setEffect(dropShadow);
        review.getStyleClass().add("text-field");

        VBox namaMakanan = new VBox(name, review);
        namaMakanan.setSpacing(10);
        layout.getChildren().add(namaMakanan);

        TextField kalori = new TextField();
        kalori.setPromptText("Kalori");
        kalori.setEffect(dropShadow);
        kalori.getStyleClass().add("text-field");

        TextField protein = new TextField();
        protein.setPromptText("Protein");
        protein.setEffect(dropShadow);
        protein.getStyleClass().add("text-field");

        TextField karbo = new TextField();
        karbo.setPromptText("Karbohidrat");
        karbo.setEffect(dropShadow);
        karbo.getStyleClass().add("text-field");
        
        TextField lemak = new TextField();
        lemak.setPromptText("Lemak");
        lemak.setEffect(dropShadow);
        lemak.getStyleClass().add("text-field");

        VBox nutrisi = new VBox(kalori, protein, karbo, lemak);
        nutrisi.setSpacing(15);

        Button tambah = new Button();
        ImageView btnTambah = new ImageView("/images/btnTambah.png");
        tambah.setGraphic(btnTambah);
        tambah.setStyle("-fx-background-color: transparent; -fx-padding: 0;");
        tambah.setOnAction(e -> {
                String textNama = name.getText();
                int intKalori = Integer.parseInt(kalori.getText());
                int intProtein = Integer.parseInt(protein.getText());
                int intKarbo = Integer.parseInt(karbo.getText());
                int intLemak = Integer.parseInt(lemak.getText());
                makanan food = new makanan(textNama, 0, intKalori, intProtein, intKarbo, intLemak);
                if (makananDao.saveMakanan(food)) {
                    System.out.println("BERHASIL TAMBAH MAKANAN");
                    ListMakanan listMakanan = new ListMakanan(stage, log, type);
                    listMakanan.show();    
                } else {
                    System.out.println("ADA INPUTAN YANG KOSONG");
                }
        });

        Button balik = new Button();
        ImageView buttonBalik = new ImageView("/images/btnBack.png");
        balik.setGraphic(buttonBalik);
        balik.setStyle("-fx-background-color: transparent; -fx-padding: 0;");
        balik.setOnAction(e -> {
            ListMakanan listMakanan = new ListMakanan(stage, log, type);
            listMakanan.show();
        });

        VBox tombol = new VBox(tambah, balik);
        tombol.setPadding(new Insets(0, 0, 0, 0));

        VBox everything = new VBox(namaMakanan, nutrisi, tombol);
        everything.setSpacing(15);
        everything.setAlignment(Pos.CENTER);
        everything.setPadding(new Insets(45, 0, 0, 40));
        layout.getChildren().addAll(everything);

        scene.getStylesheets().add("/style/TextFieldStyle.css");
        stage.setScene(scene);
        stage.show();
    }
}
