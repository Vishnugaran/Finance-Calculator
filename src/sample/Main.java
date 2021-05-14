package sample;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;



public class Main extends Application {
    public static void main(String[] args) {
        launch();
    }


    public void start (Stage primaryStage) throws Exception {
        Stage homeStage = new Stage();
        homeStage.setTitle("Finance Calculator");
        homeStage.setResizable(false);

        Button btnMortgage = new Button("Mortgage");
        Button btnSavings = new Button("Finance");
        Button btnLoan = new Button("Auto Loan");
        Button btnHelp = new Button("Help");
        Button btnExit = new Button("Exit");

        btnMortgage.setPrefSize(110, 35);
        btnSavings.setPrefSize(110, 35);
        btnLoan.setPrefSize(110, 35);
        btnHelp.setPrefSize(110, 35);
        btnExit.setPrefSize(80, 30);

        btnMortgage.setStyle("-fx-font-weight: bold; -fx-text-fill: white; -fx-background-color: #222f3e; -fx-background-radius: 20");
        btnSavings.setStyle("-fx-font-weight: bold; -fx-text-fill: white; -fx-background-color: #222f3e; -fx-background-radius: 20");
        btnLoan.setStyle("-fx-font-weight: bold; -fx-text-fill: white; -fx-background-color: #222f3e; -fx-background-radius: 20");
        btnHelp.setStyle("-fx-font-weight: bold; -fx-text-fill: white; -fx-background-color: #222f3e; -fx-background-radius: 20");
        btnExit.setStyle("-fx-font-weight: bold; -fx-text-fill: white; -fx-background-color: #d63031; -fx-background-radius: 20");

        btnExit.setLayoutX(1150);
        btnExit.setLayoutY(650);

        btnMortgage.setOnAction(event -> {
            Mortage m = new Mortage();
            m.Mortage();
        });

        btnSavings.setOnAction(event -> {
            Savings s = new Savings();
            s.Savings();
        });

        btnLoan.setOnAction(event -> {
            Loan l = new Loan();
            l.Loan();
        });

        btnHelp.setOnAction(event -> {
        Stage stage = new Stage();
        stage.setTitle("Help");

        Label label = new Label("Mortgage Calculator\n" +
                "A mortgage is a loan in which property or real estate is used as collateral. It is an agreement between the borrower and the lender. The borrower receives money from the lender to pay a home, and then makes payments with interest over a set time span until the lender is paid in full. \n" +
                "So this is used to calculate the monthly payments due along with mortgages. First you have got to enter Home price. Then Down payment, Loan term and finally Interest Rate. Finally click Calculate. Now submit it and you will have the answers.\n" +
                "Components of this calculator:\n" +
                "01. Home Price – The amount borrowed from lender\n" +
                "02. Down payment – The upfront payment of the purchase, usually a percentage of the total price\n" +
                "03. Loan term – the amount of time over which the loan must be repaid full\n" +
                "04. Interest Rate- The rate of interest charged by a mortgage lender.\n" +
                "\n" +
                "Auto loan calculator\n" +
                "\n" +
                "Use auto loan calculator to calculate monthly repayments due along with loans. First you have got to enter Auto price. Then Loan term and Interest rate, finally Down payment, finally click Calculate. Now submit it and you will have the answers.\n" +
                "Click on the total price tab in order to calculate the total price of the vehicle price. Click on the monthly payment tab in order to calculate the monthly payment of the vehicle.  \n" +
                "Components of this calculator:\n" +
                "01. Auto Price – The total loan amount\n" +
                "02. Down payment – The upfront payment of the purchase, usually a percentage of the total price\n" +
                "03. Loan term – the amount of time over which the loan must be repaid full\n" +
                "04. Interest Rate- The rate of interest charged by a lender\n" +
                "\n" +
                "Finance Calculator\n\n" +
                "This calculator is used to calculate following elements: Future value (FV), Number of compounding periods (N), Interest rate (I/Y), Annuity payment (PMT) and Start principal if other elements are known.\n" +
                "First you have got to enter suitable values in the relevant boxes. Finally click Calculate. Now submit it and you will have the answers.\n" +
                "Click on the Future value (FV) tab in order to calculate the Future value of the investment. \n" +
                "Click on the Number of compounding periods (N) tab in order to calculate the Number of compounding periods (N) of the investment. \n" +
                "Click on the Interest rate (I/Y) tab in order to calculate the Interest rate (I/Y) of the investment. \n" +
                "Click on the Annuity payment (PMT) tab in order to calculate the Annuity payment (PMT) of the investment. \n" +
                "Click on the Start principal tab in order to calculate the Start principal of the investment. \n" +
                "Similarly if you are making the regular payments at the beginning of the period click on the beginning option given below\n" +
                "Similarly if you are making the regular payments at the end of the period click on the end option given below\n\n" +
                "Components of this calculator:\n\n" +
                "01. FV- Future value of the investment\n" +
                "02. N – Number of compounding periods\n" +
                "03. I/Y- Interest rate (Annual / Monthly/ Quarterly)\n" +
                "04. PMT- Monthly payment\t\n" +
                "05. Start principal- Initial investment amount \n" +
                "\n" +
                "•\tWhen you click on the clear option all the data will be lost.\n" +
                "•\tWhen you click on the Back option the previous formula will appear\n" +
                "•\tWhen you click the exit option you will leave the software.\n" +
                "\n" +
                "\n");

        Pane pane = new Pane();
        pane.getChildren().addAll(label);

        stage.setScene(new Scene(pane, 950, 650));
        stage.showAndWait();

        });

        btnExit.setOnAction(event -> {
            homeStage.close();
        });

        VBox homeVbox = new VBox();
        homeVbox.setSpacing(5);
        homeVbox.setLayoutX(50);
        homeVbox.setLayoutY(100);
        homeVbox.getChildren().addAll(btnMortgage,btnSavings,btnLoan,btnHelp);

        Pane homePane = new Pane();
        homePane.getChildren().addAll(homeVbox, btnExit);

        homeStage.setScene(new Scene(homePane, 1300, 700));
        homeStage.showAndWait();
    }
}
