package com.example.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class HelloController {
    static double previousNumberAddition=0;
    static double previousNumberSub=0;
    static double previousNumberMultiply =1;
    static double previousNumberDivision=0;

    static double previousNumberModulus=0;
    static double staticOperation;
    @FXML

    private TextField txtDisplay;
    @FXML
    public void onDigitClick(ActionEvent event){

        String newValue = ((Button) event.getSource()).getText();
        String oldValue = txtDisplay.getText();
        txtDisplay.setText(oldValue + newValue);


    }
    @FXML
    public void onDecimalClick(ActionEvent event) {
        if (!txtDisplay.getText().contains(".")) {
            String newValue = ((Button) event.getSource()).getText();
            String oldValue = txtDisplay.getText();
            txtDisplay.setText(oldValue + newValue);

        }

    }
    @FXML
    public void onGeneralClick(ActionEvent event){
        String operation = ((Button) event.getSource()).getText();
        switch (operation) {
            case "AC" -> txtDisplay.setText("");
            case "+" -> {
                double firstNumeric = Double.parseDouble(String.valueOf(txtDisplay.getText()));
                previousNumberAddition = firstNumeric + previousNumberAddition;
                txtDisplay.setText("");
            }
            case "-/+" -> {
                double doubleNumerator = Double.parseDouble(String.valueOf(txtDisplay.getText()));
                staticOperation = doubleNumerator * -1;
                txtDisplay.setText(String.valueOf(staticOperation));
            }
            case "-" -> {
                previousNumberSub = (Double.parseDouble(String.valueOf(txtDisplay.getText())));
                txtDisplay.setText("");
            }
            case "*" -> {
                double multiplyNumerator = Double.parseDouble(String.valueOf(txtDisplay.getText()));
                previousNumberMultiply = multiplyNumerator * previousNumberMultiply;
                txtDisplay.setText("");
            }
            case "/" -> {
                previousNumberDivision = Double.parseDouble(String.valueOf(txtDisplay.getText()));
                txtDisplay.setText("");
                System.out.println(previousNumberDivision);
            }
            case "%" -> {
                double modulusNumerator = Double.parseDouble(String.valueOf(txtDisplay.getText()));
                previousNumberModulus = modulusNumerator;
                txtDisplay.setText("");
                System.out.println(modulusNumerator);
            }
        }




    }
    @FXML
    public void onEqual() {
        if (previousNumberSub != 0) {
            double subDoubleNumerator = Double.parseDouble(String.valueOf(txtDisplay.getText()));
            previousNumberSub = ((previousNumberSub) - (subDoubleNumerator));
            txtDisplay.setText(String.valueOf(previousNumberSub));
            previousNumberSub = 0;

        }
        if (previousNumberAddition != 0) {
            double additionDoubleNumerator = Double.parseDouble(String.valueOf(txtDisplay.getText()));

            previousNumberAddition = previousNumberAddition + additionDoubleNumerator;
            txtDisplay.setText(String.valueOf(previousNumberAddition));
            previousNumberAddition = 0;


        }
        if (previousNumberMultiply != 1) {
            double multiplyDoubleNumerator = Double.parseDouble(String.valueOf(txtDisplay.getText()));

            previousNumberMultiply = previousNumberMultiply * multiplyDoubleNumerator;
            txtDisplay.setText(String.valueOf(previousNumberMultiply));
            previousNumberMultiply = 1;

        }
        if (previousNumberDivision != 0) {
            double divisionDoubleNumerator = Double.parseDouble(String.valueOf(txtDisplay.getText()));

            previousNumberDivision=((previousNumberDivision)/(divisionDoubleNumerator));
            txtDisplay.setText(String.valueOf(previousNumberDivision));
            System.out.println(previousNumberDivision);
            previousNumberDivision = 0;

        }

        if (previousNumberModulus !=0){
            double modulusDoubleNumerator = Double.parseDouble(String.valueOf(txtDisplay.getText()));
            previousNumberModulus = ((previousNumberModulus)%(modulusDoubleNumerator));
            txtDisplay.setText(String.valueOf(previousNumberModulus));
            previousNumberModulus = 0;

        }



    }



}