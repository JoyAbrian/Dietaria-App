// package dietaria.scenes;

// import dietaria.dao.aktivitasDao;
// import dietaria.models.aktivitas;
// import dietaria.models.login;
// import dietaria.models.totalNutrisi;
// import dietaria.scenes.ListAktivitas;

// import javafx.geometry.Insets;
// import javafx.geometry.Pos;
// import javafx.scene.Scene;
// import javafx.scene.control.Button;
// import javafx.scene.control.Label;
// import javafx.scene.control.TextField;
// import javafx.scene.effect.DropShadow;
// import javafx.scene.image.ImageView;
// import javafx.scene.layout.StackPane;
// import javafx.scene.layout.VBox;
// import javafx.scene.text.Font;
// import javafx.stage.Stage;

// public class TambahAktivitas implements ShowMethod {
//     private Stage stage;
//     private login log;
//     private totalNutrisi total;

//     public TambahAktivitas(Stage stage, login log, totalNutrisi total) {
//         this.stage = stage;
//         this.log = log;
//         this.total = total;
//     }

//     public void show() {
//         StackPane layout = new StackPane();
//         Scene scene = new Scene(layout,340, 649);
//         ImageView bg = new ImageView("/images/bgTambahAktivitas.png");
//         layout.getChildren().add(bg);
//         bg.setFitHeight(scene.getHeight());
//         bg.setFitWidth(scene.getWidth());

//         DropShadow dropShadow = new DropShadow();
//         dropShadow.setOffsetX(2);
//         dropShadow.setOffsetY(2);
//         dropShadow.setColor(javafx.scene.paint.Color.GRAY);

//         Label nama = new Label("Nama Aktivitas");
//         nama.setFont(Font.font("Bitter", 15));
//         TextField name = new TextField();
//         name.setPromptText("Nama Aktivitas");
//         name.setEffect(dropShadow);
//         name.getStyleClass().add("text-field");
//         VBox vBoxNama = new VBox(nama, name);
//         vBoxNama.setSpacing(5);
//         vBoxNama.setPadding(new Insets(0, 0, 0, 45));
        
//         Label kaloriDibakar = new Label("Kalori Dibakar (per jam)");
//         kaloriDibakar.setFont(Font.font("Bitter", 15));
//         TextField kalori = new TextField();
//         kalori.setPromptText("Kalori yang dibakar");
//         kalori.setEffect(dropShadow);
//         kalori.getStyleClass().add("text-field");
//         VBox vBoxkalori = new VBox(kaloriDibakar, kalori);
//         vBoxkalori.setSpacing(5);
//         vBoxkalori.setPadding(new Insets(0, 0, 0, 45));

//         VBox vBox = new VBox(vBoxNama, vBoxkalori);
//         vBox.setSpacing(20);

//         Button tambah = new Button();
//         ImageView btnTambah = new ImageView("/images/btnTambah.png");
//         tambah.setGraphic(btnTambah);
//         tambah.setStyle("-fx-background-color: transparent; -fx-padding: 0;");
//         tambah.setOnAction(e -> {
//             String textNama = name.getText();
//             int intKalori = Integer.parseInt(kalori.getText());
//             aktivitas active = new aktivitas(textNama, intKalori);
//             if (aktivitasDao.saveAktivitas(active)) {
//                 System.out.println("BERHASIL TAMBAH AKTIVITAS");
//                 ListAktivitas listAktivitas = new ListAktivitas(stage, log, total);
//                 listAktivitas.show();
//             } else {
//                 System.out.println("GAGAL TAMBAH AKTIVITAS");
//             }
//         });

//         Button balik = new Button();
//         ImageView buttonBalik = new ImageView("/images/btnBack.png");
//         balik.setGraphic(buttonBalik);
//         balik.setStyle("-fx-background-color: transparent; -fx-padding: 0;");
//         balik.setOnAction(e -> {
//             ListAktivitas listAktivitas = new ListAktivitas(stage, log, total);
//             listAktivitas.show();
//         });

//         VBox tombol = new VBox(tambah, balik);
//         tombol.setPadding(new Insets(0, 0, 0, 40));

//         VBox everything = new VBox(vBox, tombol);
//         everything.setSpacing(30);
//         everything.setAlignment(Pos.CENTER);
//         layout.getChildren().add(everything);

//         scene.getStylesheets().add("/style/TextFieldStyle.css");
//         stage.setScene(scene);
//         stage.show();
//     }        
// }