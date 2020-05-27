package messenger;

import javafx.fxml.FXML;
import javafx.geometry.NodeOrientation;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Controller {
    @FXML
    private TextField textField;
    @FXML
    private TextArea textArea;

    public void onClickSend() {
        textArea.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        textArea.appendText(textField.getText() + "\n");
        textField.clear();
        textField.requestFocus();
    }

    public void clickOnExit() {
        System.exit(0);
    }

    public void enter(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            textArea.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            textArea.appendText(textField.getText() + "\n");
            textField.clear();
            textField.requestFocus();
        }
    }
}
