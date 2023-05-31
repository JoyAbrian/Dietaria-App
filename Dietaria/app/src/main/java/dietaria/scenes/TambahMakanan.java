package dietaria.scenes;

import dietaria.models.makanan;

import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TambahMakanan {
    private Stage stage;

    public TambahMakanan(Stage stage) {
        this.stage = stage;
    }

    public void show() {
        StackPane layout = new StackPane();
        Scene scene = new Scene(layout,340, 649);
        ImageView bg = new ImageView("/images/bg.png");
        layout.getChildren().add(bg);
        bg.setFitHeight(scene.getHeight());
        bg.setFitWidth(scene.getWidth());

        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(2);
        dropShadow.setOffsetY(2);
        dropShadow.setColor(javafx.scene.paint.Color.GRAY);

        stage.setScene(scene);
        stage.show();
    }
}
