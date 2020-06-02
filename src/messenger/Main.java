package messenger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.omg.CORBA.TRANSIENT;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("messenger.fxml"));
        primaryStage.setTitle("Messenger");
        primaryStage.setScene(new Scene(root, 600, 600, Color.TRANSPARENT));
        primaryStage.getScene().getStylesheets().add("messenger/style.css");
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setMinHeight(300);
        primaryStage.setMinWidth(300);
        primaryStage.show();
        com.sun.glass.ui.Window.getWindows().get(0).setUndecoratedMoveRectangle(50);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
