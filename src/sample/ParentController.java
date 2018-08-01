package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ParentController {
    private Stage parentWindowStage;
    private Stage childWindowStage;
    private ChildController childController;

    public void showHideChildWindow(ActionEvent actionEvent) {
        if (childWindowStage.isShowing()) {
            childWindowStage.hide();
        } else {
            childWindowStage.show();
        }
    }

    public void addSomethingToLog(ActionEvent actionEvent) {
        childController.addEventToLog("Some event added");
    }

    public void initChildStage(Stage primaryStage) throws Exception {
        childWindowStage = new Stage();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/child.fxml"));
        Parent root = loader.load();

        childController = loader.getController();
        childController.setStageListeners(childWindowStage);

        childWindowStage.setTitle("Child window");
        childWindowStage.setScene(new Scene(root, 600, 275));
        childWindowStage.initOwner(primaryStage.getOwner());
        parentWindowStage = primaryStage;

        parentWindowStage.setOnCloseRequest(e -> {
            System.out.println("Close request");
        });

        childWindowStage.setOnCloseRequest(e -> {
            if (!parentWindowStage.isShowing()) {
                parentWindowStage.show();
            }
        });
    }

    public void showChildAndHideParent(ActionEvent actionEvent) {
        parentWindowStage.hide();
        childWindowStage.show();
    }
}
