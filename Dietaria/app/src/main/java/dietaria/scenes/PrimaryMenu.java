package dietaria.scenes;

import dietaria.models.login;
import dietaria.utils.nutrisi;
import dietaria.utils.target;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
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

        StackPane kalori = new StackPane();
        ImageView budget = new ImageView("/images/LayerBudget.png");
        kalori.getChildren().add(budget);
        layout.getChildren().add(kalori);


        stage.setScene(scene);
        stage.show();
    }
}
