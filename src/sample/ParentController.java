package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ParentController {
    private Stage childWindowStage;

    public void showChildWindow(ActionEvent actionEvent) {
        childWindowStage.show();
    }

    public void hideChildWindow(ActionEvent actionEvent) {
        childWindowStage.hide();
    }

    public void initChildStage(Stage primaryStage) throws Exception {
        childWindowStage = new Stage();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("child.fxml"));
        Parent root = loader.load();

        ((ChildController)loader.getController()).setStageListeners(childWindowStage);

        childWindowStage.setTitle("Child window");
        childWindowStage.setScene(new Scene(root, 600, 275));
    }
}
