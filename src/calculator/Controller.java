package calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private TextField textField;

    private double var1;
    private String operation;

    public void setOperand (ActionEvent actionEvent){
        try {
            var1 = Double.parseDouble(textField.getText());
        } catch (RuntimeException e){
            textField.setText("Введите число!!!");
            return;
        }
        operation = ((Button) actionEvent.getSource()).getText();
        textField.setText("");
        textField.requestFocus();
    }

    public void clickOnStart(ActionEvent actionEvent) {

        double var2;
        try {
            var2 = Double.parseDouble(textField.getText());
        } catch (RuntimeException e){
            textField.setText("Введите число!!!");
            return;
        }

        if (operation.equals("+")) {
            textField.setText((var1 + var2) + "");
        }
        if (operation.equals("-")) {
            textField.setText((var1 - var2) + "");
        }
        if (operation.equals("*")) {
            textField.setText((var1 * var2) + "");
        }
        if (operation.equals("/")) {
            textField.setText((var1 / var2) + "");
        }
        var1 = 0;
        operation = "";
        textField.requestFocus();
    }
}
