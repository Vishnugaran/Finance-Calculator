package sample;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Loan {


    public static void Loan(){
        Calculate Calbtn  = new Calculate();
        Back Backbtn = new Back();
        KeyBrd Keybtn = new KeyBrd();
        Clear Clearbtn = new Clear();

        Stage stage = new Stage();
        stage.setTitle("Auto Loan");
        stage.initModality(Modality.WINDOW_MODAL);


        Pane pane1 = new Pane();

        Label label1 = new Label("Auto Price");
        Label label2 = new Label("Loan Term (Months)");
        Label label3 = new Label("Interest Rate (%)");
        Label label4 = new Label("Down Payment");

        TextField TPAutoPrice = new TextField();
        TextField TPLoanTerm = new TextField();
        TextField TPInterestRate = new TextField();
        TextField TPDownPayment = new TextField();

        Label lblOutputTP = new Label(" Monthly pay : ");
        lblOutputTP.setStyle("-fx-font-weight: bold; -fx-text-fill: white; -fx-background-color: #009933; -fx-font-size: 20; -fx-min-width: 350");
        lblOutputTP.setLayoutY(20);
        lblOutputTP.setLayoutX(550);

        TPAutoPrice.setOnMouseClicked(event1 -> {
            Keybtn.selectedTextField = TPAutoPrice;
        });
        TPLoanTerm.setOnMouseClicked(event1 -> {
            Keybtn.selectedTextField = TPLoanTerm;
        });
        TPInterestRate.setOnMouseClicked(event1 -> {
            Keybtn.selectedTextField = TPInterestRate;
        });
        TPDownPayment.setOnMouseClicked(event1 -> {
            Keybtn.selectedTextField = TPDownPayment;
        });
        VBox vBox1 = new VBox();
        vBox1.setSpacing(20);
        vBox1.setLayoutX(30);
        vBox1.setLayoutY(30);
        vBox1.getChildren().addAll(label1,label2,label3,label4);

        VBox vBox2 = new VBox();
        vBox2.setSpacing(8);
        vBox2.setLayoutX(170);
        vBox2.setLayoutY(30);
        vBox2.getChildren().addAll(TPAutoPrice,TPLoanTerm,TPInterestRate,TPDownPayment);

        GridPane pane1CalcUI = Keybtn.getKeyboard();
        pane1CalcUI.setLayoutX(395);
        pane1CalcUI.setLayoutY(18);

        Button backBtn1 = Backbtn.getBackBtn(stage);


        Button btnCalculate = Calbtn.getCalculateBtn();
        btnCalculate.setOnAction(event1 -> {
            double autoPrice = Double.parseDouble(TPAutoPrice.getText());
            double loanTerm = Double.parseDouble(TPLoanTerm.getText());
            double interestRate = Double.parseDouble(TPInterestRate.getText());
            double downPayment = Double.parseDouble(TPDownPayment.getText());

            double x = interestRate/12/100;
            double y = autoPrice - downPayment;
            double z = Math.pow((x+1), loanTerm);
            double tpOutput =  ((x/(z-1)) + x ) * y;
            lblOutputTP.setText(lblOutputTP.getText() + String.format("%.2f", tpOutput) + "/=");
        });
        Button btnClear = Clearbtn.getClearButton();

        btnClear.setOnAction(event -> {
            lblOutputTP.setText(" Monthly Pay : Rs.");
            TPAutoPrice.clear();
            TPLoanTerm.clear();
            TPInterestRate.clear();
            TPDownPayment.clear();
        });

        pane1.getChildren().addAll(vBox1,vBox2,pane1CalcUI, backBtn1, btnCalculate, lblOutputTP, btnClear);
//-------------------------------------------------------------------------------------------------------------------------------------
        Pane pane2 = new Pane();

        Label label5 = new Label("Monthly Pay");
        Label label6 = new Label("Loan Term (Months)");
        Label label7 = new Label("Interest Rate (%)");
        Label label8 = new Label("Down Payment");

        TextField MPMonthlyPay = new TextField();
        TextField MPLoanTerm = new TextField();
        TextField MPInterestRate = new TextField();
        TextField MPDownPayment = new TextField();

        Label lblOutputMP = new Label(" Vehicle Price : ");
        lblOutputMP.setStyle("-fx-font-weight: bold; -fx-text-fill: white; -fx-background-color: #009933; -fx-font-size: 20; -fx-min-width: 350");
        lblOutputMP.setLayoutY(20);
        lblOutputMP.setLayoutX(550);

        MPMonthlyPay.setOnMouseClicked(event1 -> {
            Keybtn.selectedTextField = MPMonthlyPay;
        });

        MPLoanTerm.setOnMouseClicked(event1 -> {
            Keybtn.selectedTextField = MPLoanTerm;
        });

        MPInterestRate.setOnMouseClicked(event1 -> {
            Keybtn.selectedTextField = MPInterestRate;
        });

        MPDownPayment.setOnMouseClicked(event1 -> {
            Keybtn.selectedTextField = MPDownPayment;
        });

        VBox vBox3 = new VBox();
        vBox3.setSpacing(20);
        vBox3.setLayoutX(30);
        vBox3.setLayoutY(30);
        vBox3.getChildren().addAll(label5,label6,label7,label8);

        VBox vBox4 = new VBox();
        vBox4.setSpacing(8);
        vBox4.setLayoutX(170);
        vBox4.setLayoutY(30);
        vBox4.getChildren().addAll(MPMonthlyPay,MPLoanTerm,MPInterestRate,MPDownPayment);

        GridPane pane2CalcUI = Keybtn.getKeyboard();
        pane2CalcUI.setLayoutX(395);
        pane2CalcUI.setLayoutY(18);

        Button backBtn2 = Backbtn.getBackBtn(stage);


        Button btnCalculate2 = Calbtn.getCalculateBtn();

        btnCalculate2.setOnAction(event1 -> {
            double mpMonthlyPay = Double.parseDouble(MPMonthlyPay.getText());
            double mpLoanTerm = Double.parseDouble(MPLoanTerm.getText());
            double mpInterestRate = Double.parseDouble(MPInterestRate.getText());
            double mpDownPayment = Double.parseDouble(MPDownPayment.getText());

            double x = mpInterestRate/12/100;
            double z = Math.pow((x+1), mpLoanTerm);
            double mpOutput = ( mpMonthlyPay / ((x/(z-1)) + x ) ) + mpDownPayment;
            lblOutputMP.setText(lblOutputMP.getText() + String.format("%.2f", mpOutput) + "/=");
        });

        Button btnClr = Clearbtn.getClearButton();
        btnClr.setOnAction(event -> {
            lblOutputMP.setText(" Monthly Pay : Rs.");
            MPMonthlyPay.clear();
            MPLoanTerm.clear();
            MPInterestRate.clear();
            MPDownPayment.clear();
        });

        pane2.getChildren().addAll(vBox3,vBox4,pane2CalcUI, backBtn2, btnCalculate2, lblOutputMP, btnClr);

        TabPane tabPane = new TabPane();
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        Tab tab1 = new Tab("Monthly Paymen", pane1);
        Tab tab2 = new Tab("Total price", pane2);

        tab1.setStyle("-fx-font-weight: bold;");
        tab2.setStyle("-fx-font-weight: bold;");

        tabPane.getTabs().addAll(tab1,tab2);

        stage.setScene(new Scene(tabPane, 950, 650));
        stage.showAndWait();
    }
}
