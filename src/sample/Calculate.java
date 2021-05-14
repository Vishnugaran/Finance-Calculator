package sample;

import javafx.scene.control.Button;

public class Calculate {

    public Button getCalculateBtn() {
        Button btnCal = new Button("Calculate");
        btnCal.setStyle("-fx-font-weight: bold; -fx-text-fill: white; -fx-background-color: #004d00; -fx-background-radius: 20; -fx-font-size: 15");
        btnCal.setPrefSize(150, 20);
        btnCal.setLayoutX(220);
        btnCal.setLayoutY(250);

        return btnCal;
    }
}
