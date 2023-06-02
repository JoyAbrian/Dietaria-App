package dietaria.scenes;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import dietaria.models.login;
import dietaria.models.totalNutrisi;
import dietaria.utils.target;

public class RincianNutrisi {
    private Stage stage;
    private login log;
    private totalNutrisi nutritionData;

    public RincianNutrisi(Stage stage, login log, totalNutrisi nutritionData) {
        this.stage = stage;
        this.log = log;
        this.nutritionData = nutritionData;
    }

    public void show() {
        StackPane layout = new StackPane();
        Scene scene = new Scene(layout, 340, 649);
        ImageView bg = new ImageView("/images/bgNutrisi.png");
        layout.getChildren().add(bg);
        bg.setFitWidth(scene.getWidth());
        bg.setFitHeight(scene.getHeight());

        Button back = new Button();
        ImageView buttonBack = new ImageView("/images/btnBack.png");
        back.setGraphic(buttonBack);
        back.setStyle("-fx-background-color: transparent; -fx-padding: 0;");
        back.setOnAction(e -> {
            PrimaryMenu primaryMenu = new PrimaryMenu(stage, log);
            primaryMenu.show();
        });

        target targetNutrition = new target(log);
        Label kaloriLabel = new Label("Kalori: " + nutritionData.getTotalKalori() + " / " + targetNutrition.getKaloriDibutuh());
        kaloriLabel.setStyle("-fx-font-size: 14px;");
        Label proteinLabel = new Label("Protein: " + nutritionData.getTotalProtein() + " / " + targetNutrition.getProteinDibutuh());
        proteinLabel.setStyle("-fx-font-size: 14px;");
        Label karbohidratLabel = new Label("Karbohidrat: " + nutritionData.getTotalKarbo() + " / " + targetNutrition.getKarbohidratDibutuh());
        karbohidratLabel.setStyle("-fx-font-size: 14px;");
        Label lemakLabel = new Label("Lemak: " + nutritionData.getTotalLemak() + " / " + targetNutrition.getLemakDibutuh());
        lemakLabel.setStyle("-fx-font-size: 14px;");

        ProgressBar kaloriBar = new ProgressBar(nutritionData.getTotalKalori() / (double) targetNutrition.getKaloriDibutuh());
        ProgressBar proteinBar = new ProgressBar(nutritionData.getTotalProtein() / (double) targetNutrition.getProteinDibutuh());
        ProgressBar karbohidratBar = new ProgressBar(nutritionData.getTotalKarbo() / (double) targetNutrition.getKarbohidratDibutuh());
        ProgressBar lemakIndicator = new ProgressBar(nutritionData.getTotalLemak() / (double) targetNutrition.getLemakDibutuh());
        
        kaloriBar.setStyle("-fx-pref-width: 200px; -fx-pref-height: 25px;");
        proteinBar.setStyle("-fx-pref-width: 200px; -fx-pref-height: 25px;");
        karbohidratBar.setStyle("-fx-pref-width: 200px; -fx-pref-height: 25px;");
        lemakIndicator.setStyle("-fx-pref-width: 200px; -fx-pref-height: 25px;");

        VBox vBox = new VBox(kaloriLabel, kaloriBar, proteinLabel, proteinBar, karbohidratLabel, karbohidratBar, lemakLabel, lemakIndicator, back);
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(10);
        layout.getChildren().add(vBox);

        stage.setScene(scene);
        stage.show();
    }

    public double hitungKalori() {
        target targetNutrition = new target(log);
        return nutritionData.getTotalKalori() / (double) targetNutrition.getKaloriDibutuh();
    }
}