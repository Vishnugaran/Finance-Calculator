
package sample;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class KeyBrd {

    TextField selectedTextField;

    private void point() {
        String value = selectedTextField.getText();
        if(value.equals("")){
            selectedTextField.setText("0.");
        }
        else {
            int count = 0;
            String[] d = value.split("");
            for(int i=0; i<d.length; i++){
                if(d[i].equals(".")){
                    selectedTextField.setText(value + "");
                    count  += 1;
                }
            }
            if(count==0){
                selectedTextField.setText(value + ".");
            }
        }
    }


    public GridPane getKeyboard() {
        GridPane keyBoard = new GridPane();
        keyBoard.setVgap(5);
        keyBoard.setHgap(5);

        Button btn1 = new Button("1");
        Button btn2 = new Button("2");
        Button btn3 = new Button("3");
        Button btn4 = new Button("4");
        Button btn5 = new Button("5");
        Button btn6 = new Button("6");
        Button btn7 = new Button("7");
        Button btn8 = new Button("8");
        Button btn9 = new Button("9");
        Button btn0 = new Button("0");
        Button btnFloat = new Button(".");
        Button btndelete = new Button("Delete");

        btn1.setOnAction(event -> {
            selectedTextField.setText(selectedTextField.getText() + "1");
        });

        btn2.setOnAction(event -> {
            selectedTextField.setText(selectedTextField.getText() + "2");
        });

        btn3.setOnAction(event -> {
            selectedTextField.setText(selectedTextField.getText() + "3");
        });

        btn4.setOnAction(event -> {
            selectedTextField.setText(selectedTextField.getText() + "4");
        });

        btn5.setOnAction(event -> {
            selectedTextField.setText(selectedTextField.getText() + "5");
        });

        btn6.setOnAction(event -> {
            selectedTextField.setText(selectedTextField.getText() + "6");
        });

        btn7.setOnAction(event -> {
            selectedTextField.setText(selectedTextField.getText() + "7");
        });

        btn8.setOnAction(event -> {
            selectedTextField.setText(selectedTextField.getText() + "8");
        });

        btn9.setOnAction(event -> {
            selectedTextField.setText(selectedTextField.getText() + "9");
        });

        btn0.setOnAction(event -> {
            selectedTextField.setText(selectedTextField.getText() + "0");
        });

        btnFloat.setOnAction(event -> {
            point();
        });

        btndelete.setOnAction(event -> {
            selectedTextField.setText("");
        });



        btn1.setStyle("-fx-font-weight: bold; -fx-background-color: #1dd1a1;");
        btn2.setStyle("-fx-font-weight: bold;  -fx-background-color: #1dd1a1;");
        btn3.setStyle("-fx-font-weight: bold; -fx-background-color: #1dd1a1;");
        btn4.setStyle("-fx-font-weight: bold; -fx-background-color: #1dd1a1;");
        btn5.setStyle("-fx-font-weight: bold; -fx-background-color: #1dd1a1;");
        btn6.setStyle("-fx-font-weight: bold; -fx-background-color: #1dd1a1;");
        btn7.setStyle("-fx-font-weight: bold; -fx-background-color: #1dd1a1;");
        btn8.setStyle("-fx-font-weight: bold; -fx-background-color: #1dd1a1;");
        btn9.setStyle("-fx-font-weight: bold; -fx-background-color: #1dd1a1;");
        btn0.setStyle("-fx-font-weight: bold; -fx-background-color: #1dd1a1;");
        btnFloat.setStyle("-fx-font-weight: bold; -fx-background-color: #1dd1a1;");
        btndelete.setStyle("-fx-font-weight: bold; -fx-background-color: #1dd1a1;");

        btn1.setPrefSize(40, 40);
        btn2.setPrefSize(40, 40);
        btn3.setPrefSize(40, 40);
        btn4.setPrefSize(40, 40);
        btn5.setPrefSize(40, 40);
        btn6.setPrefSize(40, 40);
        btn7.setPrefSize(40, 40);
        btn8.setPrefSize(40, 40);
        btn9.setPrefSize(40, 40);
        btn0.setPrefSize(85, 40);
        btnFloat.setPrefSize(40, 40);
        btndelete.setPrefSize(85, 40);

        keyBoard.add(btn1, 0 , 0,1, 1);
        keyBoard.add(btn2, 1 , 0,1, 1);
        keyBoard.add(btn3, 2 , 0,1, 1);
        keyBoard.add(btn4, 0 , 1,1, 1);
        keyBoard.add(btn5, 1 , 1,1, 1);
        keyBoard.add(btn6, 2 , 1,1, 1);
        keyBoard.add(btn7, 0 , 2,1, 1);
        keyBoard.add(btn8, 1 , 2,1, 1);
        keyBoard.add(btn9, 2 , 2,1, 1);
        keyBoard.add(btn0, 0 , 3,2, 1);
        keyBoard.add(btnFloat, 2 , 3,1, 1);
        keyBoard.add(btndelete, 3,3, 2, 1);

        keyBoard.setLayoutX(415);
        keyBoard.setLayoutY(18);

        return keyBoard;
    }

}
