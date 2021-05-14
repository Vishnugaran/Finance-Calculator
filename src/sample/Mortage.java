package sample;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Mortage {

    public static void Mortage(){
        Calculate Calbtn  = new Calculate();
        Back Backbtn = new Back();
        KeyBrd Keybtn = new KeyBrd();
        Clear Clearbtn = new Clear();

        Stage stage = new Stage();
        stage.setTitle("Mortgage Calculator");


        Label label1 = new Label("Home price");
        Label label2 = new Label("Down Payment");
        Label label3 = new Label("Loan Term(Years)");
        Label label4 = new Label("Interest Rate (%)");

        TextField mortgageHomePrice = new TextField();
        TextField mortgageDownPayment = new TextField();
        TextField mortgageLoanTerm = new TextField();
        TextField mortgageRate = new TextField();

        label1.setStyle("-fx-font-weight: bold;");
        label2.setStyle("-fx-font-weight: bold;");
        label3.setStyle("-fx-font-weight: bold;");
        label4.setStyle("-fx-font-weight: bold;");

        mortgageHomePrice.setOnMouseClicked(event1 -> {
            Keybtn.selectedTextField = mortgageHomePrice;
        });

        mortgageDownPayment.setOnMouseClicked(event1 -> {
            Keybtn.selectedTextField = mortgageDownPayment;
        });

        mortgageLoanTerm.setOnMouseClicked(event1 -> {
            Keybtn.selectedTextField = mortgageLoanTerm;
        });

        mortgageRate.setOnMouseClicked(event1 -> {
            Keybtn.selectedTextField = mortgageRate;
        });

        VBox vBox1 = new VBox();
        vBox1.setSpacing(18);
        vBox1.setLayoutX(30);
        vBox1.setLayoutY(30);
        vBox1.getChildren().addAll(label1,label2,label3,label4);

        VBox vBox2 = new VBox();
        vBox2.setSpacing(8);
        vBox2.setLayoutX(150);
        vBox2.setLayoutY(30);
        vBox2.getChildren().addAll(mortgageHomePrice,mortgageDownPayment,mortgageLoanTerm,mortgageRate);

        GridPane calcUI = Keybtn.getKeyboard();
        calcUI.setLayoutX(350);
        calcUI.setLayoutY(18);

        Button btnCalculate = Calbtn.getCalculateBtn();

        Label lblOutput = new Label(" Monthly Pay : Rs.");
        lblOutput.setLayoutX(550);
        lblOutput.setLayoutY(20);
        lblOutput.setStyle("-fx-font-weight: bold; -fx-text-fill: white; -fx-background-color: #009933; -fx-font-size:20; -fx-min-width: 350");

        btnCalculate.setOnAction(event1 -> {
            double homePrice = Double.parseDouble(mortgageHomePrice.getText());
            double downPayment = Double.parseDouble(mortgageDownPayment.getText());
            double loanTerm = Double.parseDouble(mortgageLoanTerm.getText());
            double rate = Double.parseDouble(mortgageRate.getText());

            double p = homePrice - downPayment;
            double r = (rate/100) / 12;
            double y = loanTerm * 12;
            double x = Math.pow((1+r), y);

            double output = (p*x*r) / (x-1);
            lblOutput.setText(lblOutput.getText() + String.format("%.2f", output) + "/=");
        });

        Button btnClear = Clearbtn.getClearButton();
        btnClear.setOnAction(event -> {
            lblOutput.setText(" Monthly Pay : Rs.");
            mortgageHomePrice.clear();
            mortgageDownPayment.clear();
            mortgageLoanTerm .clear();
            mortgageRate .clear();

        });

        Button btnBack = Backbtn.getBackBtn(stage);

        Pane pane = new Pane();
        pane.getChildren().addAll(vBox1,vBox2,calcUI, btnBack, btnCalculate, lblOutput, btnClear);

        stage.setScene(new Scene(pane, 950, 650));
        stage.showAndWait();
    }
}
