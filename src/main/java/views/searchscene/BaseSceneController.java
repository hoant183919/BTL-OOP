package views.searchscene;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class BaseSceneController {
    @FXML
    Label nguonLabel;
    @FXML
    Label idLabel;
    @FXML
    Label moTaLabel;
    @FXML
    public void backToSearchScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(("/searchscene/SearchScene.fxml")));
        Scene splashScene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(splashScene);
        stage.show();
    }

}
