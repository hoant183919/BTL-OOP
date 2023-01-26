package views.searchscene;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import utils.configs.ConfigResourceFXML;

import java.io.IOException;

public class BaseSceneController {
    @FXML
    Label moTaLabel;

    // Back to Search Scene
    @FXML
    public void backToSearchScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource((ConfigResourceFXML.SEARCH_SCENE_PATH)));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}

