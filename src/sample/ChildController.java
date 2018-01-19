package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class ChildController implements Initializable {

    @FXML
    TextArea textArea;

    public void addEventToLog(String event) {
        textArea.appendText(new Date() + " " + event + "\n");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        textArea.appendText(new Date() + " Child window initialization" + "\n");
    }

    public void setStageListeners(Stage childWindowStage) {
        childWindowStage.setOnShowing(event -> {
            textArea.appendText(new Date() + " Child window showing" + "\n");
        });

        childWindowStage.setOnHiding(event -> {
            textArea.appendText(new Date() + " Child window hiding" + "\n");
        });
    }
}
