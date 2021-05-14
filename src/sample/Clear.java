package sample;

import javafx.scene.control.Button;

public class Clear {
    public Button getClearButton(){
        Button btnClear = new Button("Clear");
        btnClear.setStyle("-fx-font-weight: bold; -fx-text-fill: white; -fx-background-color: #0abde3; -fx-background-radius: 20; -fx-font-size: 15");
        btnClear.setPrefSize(150, 30);
        btnClear.setLayoutX(400);
        btnClear.setLayoutY(250);
        return btnClear;
    }
}
