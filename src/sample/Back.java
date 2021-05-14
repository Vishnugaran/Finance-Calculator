
package sample;

import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Back {

    public Button getBackBtn(Stage currentStage) {
        Button btnBack = new Button("Back");
        btnBack.setStyle("-fx-font-weight: bold; -fx-text-fill: white; -fx-background-color: #2d3436; -fx-background-radius: 20");
        btnBack.setPrefSize(80, 30);
        btnBack.setLayoutX(750);
        btnBack.setLayoutY(550);
        btnBack.setOnAction(event -> {
            currentStage.close();
        });

        return btnBack;
    }

}
