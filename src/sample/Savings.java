package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Savings {
    public static void Savings(){
        Calculate Calbtn  = new Calculate();
        Back Backbtn = new Back();
        KeyBrd Keybtn = new KeyBrd();
        Clear Clearbtn = new Clear();

        Stage stage = new Stage();
        stage.setTitle("Finance");
        stage.initModality(Modality.WINDOW_MODAL);

        Pane pane1 = new Pane();

        Label label1 = new Label("N (# of periods)");
        Label label2 = new Label("Start Principal");
        Label label3 = new Label("I/Y (Interest)");
        Label label4 = new Label("PMT (Annuity Payment)");
        Label label21 = new Label("Payment at");

        ToggleGroup tg = new ToggleGroup();
        RadioButton r1 = new RadioButton(" Beginning");
        r1.setLayoutX(200);
        r1.setLayoutY(210);

        RadioButton r2 = new RadioButton(" End");
        r2.setLayoutX(330);
        r2.setLayoutY(210);

        r1.setToggleGroup(tg);
        r2.setToggleGroup(tg);

        pane1.getChildren().add(r1);
        pane1.getChildren().add(r2);


        TextField FVPeriods = new TextField();
        TextField FVStartPrincipal = new TextField();
        TextField FVInterest = new TextField();
        TextField FVPMT = new TextField();

        Label lblOutputFV = new Label(" FV : ");
        lblOutputFV.setStyle("-fx-font-weight: bold; -fx-text-fill: white; -fx-background-color: #009933; -fx-font-size: 20; -fx-min-width: 350");
        lblOutputFV.setLayoutX(550);
        lblOutputFV.setLayoutY(20);

        FVPeriods.setOnMouseClicked(event1 -> {
            Keybtn.selectedTextField = FVPeriods;
        });

        FVStartPrincipal.setOnMouseClicked(event1 -> {
            Keybtn.selectedTextField = FVStartPrincipal;
        });

        FVInterest.setOnMouseClicked(event1 -> {
            Keybtn.selectedTextField = FVInterest;
        });

        FVPMT.setOnMouseClicked(event1 -> {
            Keybtn.selectedTextField = FVPMT;
        });

        VBox vBox1 = new VBox();
        vBox1.setSpacing(20);
        vBox1.setLayoutX(30);
        vBox1.setLayoutY(30);
        vBox1.getChildren().addAll(label1,label2,label3,label4, label21);

        VBox vBox2 = new VBox();
        vBox2.setSpacing(8);
        vBox2.setLayoutX(200);
        vBox2.setLayoutY(30);
        vBox2.getChildren().addAll(FVPeriods, FVStartPrincipal, FVInterest, FVPMT);

        GridPane Pane1calcUI = Keybtn.getKeyboard();

        Button btnBack1 = Backbtn.getBackBtn(stage);

        Button btnCalculate1 = Calbtn.getCalculateBtn();
        Button btnClear = Clearbtn.getClearButton();

        btnClear.setOnAction(event -> {
            lblOutputFV.setText(" FV : ");
            FVPeriods.clear();
            FVStartPrincipal.clear();
            FVInterest .clear();
            FVPMT .clear();

        });

        tg.selectedToggleProperty().addListener(new ChangeListener<Toggle>()
        {
            public void changed(ObservableValue<? extends Toggle> ob,
                                Toggle o, Toggle n)
            {

                RadioButton rb = (RadioButton)tg.getSelectedToggle();
                btnCalculate1.setOnAction(event1 -> {
                    double fvPeriods = Double.parseDouble(FVPeriods.getText());
                    double fvPresentValue = Double.parseDouble(FVStartPrincipal.getText());
                    double fvInterest = Double.parseDouble(FVInterest.getText());
                    double fvPMT = Double.parseDouble(FVPMT.getText());

                    if(rb == r1){
                        double i = fvInterest/100;
                        double x = Math.pow((i+1) , fvPeriods);
                        double fvOutput = ((1/i) * (((i*(-1))*((fvPMT*x) - fvPMT + (fvPresentValue*x))) - (fvPMT*x) + fvPMT)) * (-1)  ;
                        lblOutputFV.setText(lblOutputFV.getText() + String.format("%.2f", fvOutput) + "/=");
                    }
                    else if(rb == r2){
                        double i = fvInterest/100;
                        double x = Math.pow((i+1) , fvPeriods);
                        double fvOutput = (1/i)*(((-1)*i*x*fvPresentValue) - (fvPMT*x) + fvPMT)*(-1);
                        lblOutputFV.setText(lblOutputFV.getText() + String.format("%.2f", fvOutput) + "/=");
                    }

                });

            }
        });



        pane1.getChildren().addAll(vBox1,vBox2, Pane1calcUI, btnBack1, btnCalculate1,lblOutputFV,btnClear);
//-----------------------------------------------------------------------------------------------------------------------------------------------------
        Pane pane2 = new Pane();

        Label label5 = new Label("FV (Future Values)");
        Label label6 = new Label("N (# of periods)");
        Label label7 = new Label("Start Principal");
        Label label8 = new Label("I/Y (Interest)");
        Label label22 = new Label("Payment at");

        ToggleGroup tg1 = new ToggleGroup();
        RadioButton r3 = new RadioButton(" Beginning");
        r3.setLayoutX(200);
        r3.setLayoutY(210);

        RadioButton r4 = new RadioButton(" End");
        r4.setLayoutX(330);
        r4.setLayoutY(210);

        r3.setToggleGroup(tg1);
        r4.setToggleGroup(tg1);

        pane2.getChildren().add(r3);
        pane2.getChildren().add(r4);

        TextField PMTFV = new TextField();
        TextField PMTN = new TextField();
        TextField PMTPrincipal = new TextField();
        TextField PMTInterest = new TextField();

        Label lblOutputPMT = new Label(" PMT : ");
        lblOutputPMT.setStyle("-fx-font-weight: bold; -fx-text-fill: white; -fx-background-color: #009933; -fx-font-size: 20; -fx-min-width: 350");
        lblOutputPMT.setLayoutX(550);
        lblOutputPMT.setLayoutY(20);

        PMTFV.setOnMouseClicked(event1 -> {
            Keybtn.selectedTextField = PMTFV;
        });

        PMTN.setOnMouseClicked(event1 -> {
            Keybtn.selectedTextField = PMTN;
        });

        PMTPrincipal.setOnMouseClicked(event1 -> {
            Keybtn.selectedTextField = PMTPrincipal;
        });

        PMTInterest.setOnMouseClicked(event1 -> {
            Keybtn.selectedTextField = PMTInterest;
        });

        VBox vBox3 = new VBox();
        vBox3.setSpacing(20);
        vBox3.setLayoutX(30);
        vBox3.setLayoutY(30);
        vBox3.getChildren().addAll(label5,label6,label7,label8,label22);

        VBox vBox4 = new VBox();
        vBox4.setSpacing(8);
        vBox4.setLayoutX(200);
        vBox4.setLayoutY(30);
        vBox4.getChildren().addAll(PMTFV, PMTN, PMTPrincipal, PMTInterest);

        GridPane Pane2calcUI = Keybtn.getKeyboard();

        Button btnBack2 = Backbtn.getBackBtn(stage);

        Button btnCalculate2 = Calbtn.getCalculateBtn();

        tg1.selectedToggleProperty().addListener(new ChangeListener<Toggle>()
        {
            public void changed(ObservableValue<? extends Toggle> ob,
                                Toggle o, Toggle n)
            {

                RadioButton rb = (RadioButton)tg1.getSelectedToggle();
                btnCalculate2.setOnAction(event1 -> {
                    double pmtFV = Double.parseDouble(PMTFV.getText());
                    double pmtN = Double.parseDouble(PMTN.getText());
                    double pmtPrincipal = Double.parseDouble(PMTPrincipal.getText());
                    double pmtI = Double.parseDouble(PMTInterest.getText());

                    double i = pmtI/100;
                    double x = Math.pow((i+1) , pmtN);
                    double y=(x-1)*100/pmtI;
                    double z=Math.pow(i+1,pmtN)*pmtPrincipal;
                    if(rb == r3){
                        double pmtOutput = (pmtFV-z)/y ;
                        lblOutputPMT.setText(lblOutputPMT.getText() + String.format("%.2f", pmtOutput) + "/=");
                    }
                    else if(rb == r4){
                        double pmtOutput=(pmtFV-z)/((i+1)*y);
                        lblOutputPMT.setText(lblOutputPMT.getText() + String.format("%.2f", pmtOutput) + "/=");
                    }

                });

            }
        });

        Button btnClear1 = Clearbtn.getClearButton();
        btnClear1.setOnAction(event -> {
            lblOutputPMT.setText(" PMT : ");
            PMTFV.clear();
            PMTN.clear();
            PMTPrincipal .clear();
            PMTInterest .clear();

        });


        pane2.getChildren().addAll(vBox3,vBox4, Pane2calcUI, btnBack2, btnCalculate2, lblOutputPMT,btnClear1);
//-----------------------------------------------------------------------------------------------------------------------------------------------------
        Pane pane3 = new Pane();

        Label label9 = new Label("FV (Future Values)");
        Label label10 = new Label("N (# of periods)");
        Label label11 = new Label("Start Principal");
        Label label12 = new Label("PMT (Annuity Payment)");
        Label label23 = new Label("Payment at");

        ToggleGroup tg2 = new ToggleGroup();
        RadioButton r5 = new RadioButton(" Beginning");
        r5.setLayoutX(200);
        r5.setLayoutY(210);

        RadioButton r6 = new RadioButton(" End");
        r6.setLayoutX(330);
        r6.setLayoutY(210);

        r5.setToggleGroup(tg2);
        r6.setToggleGroup(tg2);

        pane3.getChildren().add(r5);
        pane3.getChildren().add(r6);

        TextField IYFV = new TextField();
        TextField IYPeriods = new TextField();
        TextField IYPrincipal = new TextField();
        TextField IYPMT = new TextField();

        Label lblOutputIY = new Label(" I/Y : ");
        lblOutputIY.setStyle("-fx-font-weight: bold; -fx-text-fill: white; -fx-background-color: #009933; -fx-font-size: 20; -fx-min-width: 350");
        lblOutputIY.setLayoutX(550);
        lblOutputIY.setLayoutY(20);


        IYFV.setOnMouseClicked(event1 -> {
            Keybtn.selectedTextField = IYFV;
        });

        IYPeriods.setOnMouseClicked(event1 -> {
            Keybtn.selectedTextField = IYPeriods;
        });

        IYPrincipal.setOnMouseClicked(event1 -> {
            Keybtn.selectedTextField = IYPrincipal;
        });

        IYPMT.setOnMouseClicked(event1 -> {
            Keybtn.selectedTextField = IYPMT;
        });

        VBox vBox5 = new VBox();
        vBox5.setSpacing(20);
        vBox5.setLayoutX(30);
        vBox5.setLayoutY(30);
        vBox5.getChildren().addAll(label9,label10,label11,label12,label23);

        VBox vBox6 = new VBox();
        vBox6.setSpacing(8);
        vBox6.setLayoutX(200);
        vBox6.setLayoutY(30);
        vBox6.getChildren().addAll(IYFV, IYPeriods, IYPrincipal, IYPMT);

        GridPane Pane3calcUI = Keybtn.getKeyboard();

        Button btnBack3 = Backbtn.getBackBtn(stage);

        Button btnCalculate3 = Calbtn.getCalculateBtn();

        Button btnClear2 = Clearbtn.getClearButton();
        btnClear2.setOnAction(event -> {
            lblOutputIY.setText(" I/Y : ");
            IYFV.clear();
            IYPeriods.clear();
            IYPrincipal .clear();
            IYPMT .clear();

        });

        pane3.getChildren().addAll(vBox5,vBox6, Pane3calcUI, btnBack3, btnCalculate3, lblOutputIY,btnClear2);
//-----------------------------------------------------------------------------------------------------------------------------------------------------
        Pane pane4 = new Pane();

        Label label13 = new Label("FV (Future Values)");
        Label label14 = new Label("Start Principal");
        Label label15 = new Label("I/Y (Interest)");
        Label label16 = new Label("PMT (Annuity Payment)");
        Label label24 = new Label("Payment at");

        ToggleGroup tg3 = new ToggleGroup();
        RadioButton r7 = new RadioButton(" Beginning");
        r7.setLayoutX(200);
        r7.setLayoutY(210);

        RadioButton r8 = new RadioButton(" End");
        r8.setLayoutX(330);
        r8.setLayoutY(210);

        r7.setToggleGroup(tg3);
        r8.setToggleGroup(tg3);

        pane4.getChildren().add(r7);
        pane4.getChildren().add(r8);

        TextField NFV = new TextField();
        TextField NPrincipal = new TextField();
        TextField NInterest = new TextField();
        TextField NPMT = new TextField();

        Label lblOutputN = new Label(" N of periods : ");
        lblOutputN.setStyle("-fx-font-weight: bold; -fx-text-fill: white; -fx-background-color: #009933; -fx-font-size: 20; -fx-min-width: 350");
        lblOutputN.setLayoutX(550);
        lblOutputN.setLayoutY(20);

        NFV.setOnMouseClicked(event1 -> {
            Keybtn.selectedTextField = NFV;
        });

        NPrincipal.setOnMouseClicked(event1 -> {
            Keybtn.selectedTextField = NPrincipal;
        });

        NInterest.setOnMouseClicked(event1 -> {
            Keybtn.selectedTextField = NInterest;
        });

        NPMT.setOnMouseClicked(event1 -> {
            Keybtn.selectedTextField = NPMT;
        });

        VBox vBox7 = new VBox();
        vBox7.setSpacing(20);
        vBox7.setLayoutX(30);
        vBox7.setLayoutY(30);
        vBox7.getChildren().addAll(label13,label14,label15,label16,label24);

        VBox vBox8 = new VBox();
        vBox8.setSpacing(8);
        vBox8.setLayoutX(200);
        vBox8.setLayoutY(30);
        vBox8.getChildren().addAll(NFV, NPrincipal, NInterest, NPMT);

        GridPane Pane4calcUI = Keybtn.getKeyboard();

        Button btnBack4 = Backbtn.getBackBtn(stage);

        Button btnCalculate4 = Calbtn.getCalculateBtn();
        tg3.selectedToggleProperty().addListener(new ChangeListener<Toggle>()
        {
            public void changed(ObservableValue<? extends Toggle> ob,
                                Toggle o, Toggle n)
            {

                RadioButton rb = (RadioButton)tg3.getSelectedToggle();
                btnCalculate4.setOnAction(event1 -> {
                    double nFV = Double.parseDouble(NFV.getText());
                    double nPrincipal = Double.parseDouble(NPrincipal.getText());
                    double nInterest = Double.parseDouble(NInterest.getText());
                    double nPMT = Double.parseDouble(NPMT.getText());

                    double i = nInterest/100;
                    if(rb == r7){
                        double nOutput = (1/Math.log(i+1)) * Math.log(((nFV*(1)*i) + (i*nPMT) + nPMT) / ((i*nPMT) + (i*nPrincipal) + nPMT));
                        lblOutputN.setText(lblOutputN.getText() + String.format("%.2f", nOutput));
                    }
                    else if(rb == r8){
                        double nOutput = Math.log(((nFV*(1)*i)+nPMT) / ((i*nPrincipal)+nPMT)) / Math.log(i+1);
                        lblOutputN.setText(lblOutputN.getText() + String.format("%.2f", nOutput));
                    }

                });

            }
        });

        Button btnClear3 = Clearbtn.getClearButton();
        btnClear3.setOnAction(event -> {
            lblOutputN.setText(" N : ");
            NFV.clear();
            NPrincipal.clear();
            NInterest .clear();
            NPMT .clear();

        });


        pane4.getChildren().addAll(vBox7,vBox8, Pane4calcUI, btnBack4, btnCalculate4, btnClear3,lblOutputN);
//-----------------------------------------------------------------------------------------------------------------------------------------------------
        Pane pane5 = new Pane();

        Label label17 = new Label("FV (Future Values)");
        Label label18 = new Label("N (# of periods)");
        Label label19 = new Label("I/Y (Interest)");
        Label label20 = new Label("PMT (Annuity Payment)");
        Label label25 = new Label("Payment at");

        ToggleGroup tg4 = new ToggleGroup();
        RadioButton r9 = new RadioButton(" Beginning");
        r9.setLayoutX(200);
        r9.setLayoutY(210);

        RadioButton r10 = new RadioButton(" End");
        r10.setLayoutX(330);
        r10.setLayoutY(210);

        r9.setToggleGroup(tg4);
        r10.setToggleGroup(tg4);

        pane5.getChildren().add(r9);
        pane5.getChildren().add(r10);

        TextField SPFV = new TextField();
        TextField SPN = new TextField();
        TextField SPInterest = new TextField();
        TextField SPPMT = new TextField();

        Label lblOutputSP = new Label(" Start Principal : ");
        lblOutputSP.setStyle("-fx-font-weight: bold; -fx-text-fill: white; -fx-background-color: #009933; -fx-font-size: 20; -fx-min-width: 350");
        lblOutputSP.setLayoutX(550);
        lblOutputSP.setLayoutY(20);

        SPFV.setOnMouseClicked(event1 -> {
            Keybtn.selectedTextField = SPFV;
        });

        SPN.setOnMouseClicked(event1 -> {
            Keybtn.selectedTextField = SPN;
        });

        SPInterest.setOnMouseClicked(event1 -> {
            Keybtn.selectedTextField = SPInterest;
        });

        SPPMT.setOnMouseClicked(event1 -> {
            Keybtn.selectedTextField = SPPMT;
        });

        VBox vBox9 = new VBox();
        vBox9.setSpacing(20);
        vBox9.setLayoutX(30);
        vBox9.setLayoutY(30);
        vBox9.getChildren().addAll(label17,label18,label19,label20,label25);

        VBox vBox10 = new VBox();
        vBox10.setSpacing(8);
        vBox10.setLayoutX(200);
        vBox10.setLayoutY(30);
        vBox10.getChildren().addAll(SPFV, SPN, SPInterest, SPPMT);

        GridPane Pane5calcUI = Keybtn.getKeyboard();

        Button btnBack5 = Backbtn.getBackBtn(stage);

        Button btnCalculate5 = Calbtn.getCalculateBtn();

        tg4.selectedToggleProperty().addListener(new ChangeListener<Toggle>()
        {
            public void changed(ObservableValue<? extends Toggle> ob,
                                Toggle o, Toggle n)
            {

                RadioButton rb = (RadioButton)tg4.getSelectedToggle();
                btnCalculate5.setOnAction(event1 -> {
                    double spFV = Double.parseDouble(SPFV.getText());
                    double spN = Double.parseDouble(SPN.getText());
                    double spInterest = Double.parseDouble(SPInterest.getText());
                    double spPMT = Double.parseDouble(SPPMT.getText());

                    double i = spInterest/100;
                    double x = Math.pow((i+1), ((-1)*spN));
                    double y = Math.pow((i+1), spN);
                    if(rb == r9){
                        double spOutput = ((1)*spFV*x) - spPMT + (spPMT*x) - (spPMT/i) + ((spPMT/i)*x);
                        lblOutputSP.setText(lblOutputSP.getText() + String.format("%.2f", spOutput)+ "/=");
                    }
                    else if(rb == r10){
                        double spOutput = ((1/i)*x) * ((spFV*(1)*i) - (spPMT*y) + spPMT) ;
                        lblOutputSP.setText(lblOutputSP.getText() + String.format("%.2f", spOutput)+ "/=");
                    }

                });
            }
        });

        Button btnClear4 = Clearbtn.getClearButton();
        btnClear4.setOnAction(event -> {
            lblOutputSP.setText("Start Principal : ");
            SPFV.clear();
            SPN.clear();
            SPInterest .clear();
            SPPMT .clear();

        });

        pane5.getChildren().addAll(vBox9,vBox10, Pane5calcUI, btnBack5, btnCalculate5,btnClear4, lblOutputSP);

        TabPane tabPane = new TabPane();
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        Tab tab1 = new Tab("FV", pane1);
        Tab tab2 = new Tab("PMT", pane2);
        Tab tab3 = new Tab("I/Y", pane3);
        Tab tab4 = new Tab("N", pane4);
        Tab tab5 = new Tab("Start Principal", pane5);

        tab1.setStyle("-fx-font-weight: bold;");
        tab2.setStyle("-fx-font-weight: bold;");
        tab3.setStyle("-fx-font-weight: bold;");
        tab4.setStyle("-fx-font-weight: bold;");
        tab5.setStyle("-fx-font-weight: bold;");

        tabPane.getTabs().addAll(tab1,tab2,tab3,tab4,tab5);

        stage.setScene(new Scene(tabPane, 950, 650));
        stage.showAndWait();


    }
}
