package dietaria.scenes;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import dietaria.models.login;

public class RincianNutrisi {
    private Stage stage;
    private login log;

    public RincianNutrisi(Stage stage, login log) {
        this.stage = stage;
        this.log = log;
    }

    public void show() {
        StackPane layout = new StackPane();
        Scene scene = new Scene(layout,340, 649);
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

        VBox vBox = new VBox(back);
        layout.getChildren().add(vBox);
        stage.setScene(scene);
        stage.show();
    }
}
