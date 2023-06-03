// package dietaria.scenes;

// import java.util.ArrayList;
// import java.util.HashMap;

// import dietaria.dao.aktivitasDao;
// import dietaria.models.aktivitas;
// import dietaria.models.login;
// import dietaria.models.makanan;
// import dietaria.models.totalNutrisi;
// import dietaria.scenes.TambahMakanan;

// import javafx.geometry.Insets;
// import javafx.geometry.Pos;
// import javafx.scene.Scene;
// import javafx.scene.control.Button;
// import javafx.scene.control.Label;
// import javafx.scene.control.ScrollPane;
// import javafx.scene.control.TableColumn;
// import javafx.scene.control.TableView;
// import javafx.scene.control.cell.PropertyValueFactory;
// import javafx.scene.image.ImageView;
// import javafx.scene.layout.BorderPane;
// import javafx.scene.layout.HBox;
// import javafx.scene.layout.StackPane;
// import javafx.scene.layout.VBox;
// import javafx.scene.paint.Color;
// import javafx.scene.text.Font;
// import javafx.stage.Stage;

// public class ListAktivitas implements ShowMethod {
//     private Stage stage;
//     private login log;
//     private aktivitas aktivitasPilihan;
//     private totalNutrisi total;

//     public ListAktivitas(Stage stage, login log, totalNutrisi total) {
//         this.stage = stage;
//         this.log = log;
//         this.total = total;
//     }
    
//     public void show() {
//         StackPane layout = new StackPane();
//         Scene scene = new Scene(layout,340, 649);
//         ImageView bg = new ImageView("/images/bgPilihAktivitas.png");
//         layout.getChildren().add(bg);
//         bg.setFitHeight(scene.getHeight());
//         bg.setFitWidth(scene.getWidth());

//         Button tambah = new  Button();
//         ImageView btnTambah = new ImageView("/images/btnAdd.png");
//         tambah.setGraphic(btnTambah);
//         tambah.setStyle("-fx-background-color: transparent; -fx-padding: 0;");
//         tambah.setOnAction(e -> {
//             TambahAktivitas tambahAktivitas = new TambahAktivitas(stage, log, total);
//             tambahAktivitas.show();
//         });

//         VBox buttonTambah = new VBox(tambah);
//         buttonTambah.setAlignment(Pos.BOTTOM_RIGHT);
//         buttonTambah.setPadding(new Insets(0, 30, 30, 0));
        
//         Button balik = new Button();
//         ImageView btnBalik = new ImageView("/images/btnBalik.png");
//         balik.setGraphic(btnBalik);
//         balik.setStyle("-fx-background-color: transparent; -fx-padding: 0;");
//         balik.setOnAction(e -> {
//             PrimaryMenu primaryMenu = new PrimaryMenu(stage, log, total);
//             primaryMenu.show();
//         });

//         VBox buttonBalik = new VBox(balik);
//         buttonBalik.setAlignment(Pos.TOP_LEFT);
//         buttonBalik.setPadding(new Insets(35, 0, 0, 10));

//         VBox activity = new VBox();
//         ArrayList<aktivitas> aktivitasList = aktivitasDao.getAllAktivitas();
        
//         for (aktivitas aktif : aktivitasList) {
//             StackPane stackPane = new StackPane();
//             ImageView layer = new ImageView("/images/layerListMakanan.png");
//             stackPane.getChildren().add(layer);
        
//             Label activityName = new Label(aktif.getNama());
//             activityName.setFont(Font.font("GEORGIA", 20));
//             activityName.setTextFill(Color.WHITE);

//             HBox composContainer = new HBox(10);
//             HashMap<String, String> attributes = aktif.toHashMap();
        
//             attributes.forEach((attrName, value) -> {
//                 Label compositionName = new Label(attrName);
//                 compositionName.setFont(Font.font("CHARLEMAGNE STD BOLD", 15));
//                 compositionName.setTextFill(Color.WHITE);    
//                 Label compositionValue = new Label(value);
//                 compositionValue.setFont(Font.font("CHARLEMAGNE STD BOLD", 15));
//                 compositionValue.setTextFill(Color.WHITE);    
//                 composContainer.getChildren().addAll(compositionName, compositionValue);
//             });
        
//             VBox isi = new VBox(10, activityName, composContainer);
//             isi.setPadding(new Insets(10, 0, 0, 10));
//             isi.setOnMouseClicked(e -> {
//                 PrimaryMenu.addAktivitas(aktif);
//                 aktivitasPilihan = aktif;
//                 PrimaryMenu primaryMenu = new PrimaryMenu(stage, log, aktif);
//                 primaryMenu.show();
//             });
//             stackPane.getChildren().add(isi);
//             activity.getChildren().addAll(stackPane);
//         }
        
//         ScrollPane scrollPane = new ScrollPane(activity);
//         scrollPane.setMaxWidth(300);
//         scrollPane.setMinHeight(400);
//         scrollPane.setStyle("-fx-background-color: transparent; -fx-background: transparent; -fx-border-color: transparent;");
//         scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
//         scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        
//         BorderPane container = new BorderPane();
//         container.setCenter(scrollPane);
//         container.setPadding(new Insets(50, 0, 0, 0));

//         VBox everything = new VBox(buttonBalik, container, buttonTambah);
//         layout.getChildren().add(everything);

//         stage.setScene(scene);
//         stage.show();
//     }
// }
