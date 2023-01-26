package views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.SplitMenuButton;
import javafx.stage.Stage;
import utils.configs.ConfigResourceFXML;

import java.io.IOException;

public class SplashSceneController {
    private Stage stage;
    private Scene scene;

    @FXML
    SplitMenuButton searchButton;


    // Switch to DataCollection Scene
    @FXML
    public void switchToDataCollectionScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource((ConfigResourceFXML.DATA_COLLECTION_SCENE)));
        scene = new Scene(root);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    // Switch to DataSummary Scene
    @FXML
    public void switchToDataSummaryScene(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource((ConfigResourceFXML.DATA_SUMMARY_SCENE)));
        scene = new Scene(root);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    // Switch to Search Scene
    @FXML
    public void switchToSearchScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource((ConfigResourceFXML.SEARCH_SCENE_PATH)));
        scene = new Scene(root);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

}
