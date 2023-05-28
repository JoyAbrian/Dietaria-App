package dietaria.scenes;

import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class RegisterMenu1 {
    private Stage stage;

    public RegisterMenu1(Stage stage) {
        this.stage = stage;
    }

    public void show() {
        StackPane layout = new StackPane();
        ImageView bg = new ImageView("/images/bgHome.png");
        layout.getChildren().add(bg);

        Scene scene = new Scene(layout,340, 649);
        stage.setScene(scene);
        stage.show();
    }
}