package views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import utils.configs.ConfigResourceFXML;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SplashSceneHandler implements Initializable {
    private Stage stage;
    private Scene scene;
    @FXML
    ImageView imageView;
    // Switch to DataCollection Scene
    @FXML
    public void switchToDataCollectionScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource((ConfigResourceFXML.DATA_COLLECTION_SCENE)));
        scene = new Scene(root);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }

    // Switch to DataSummary Scene
    @FXML
    public void switchToDataSummaryScene(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource((ConfigResourceFXML.DATA_SUMMARY_SCENE)));
        scene = new Scene(root);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }

    // Switch to Search Scene
    @FXML
    public void switchToSearchScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource((ConfigResourceFXML.SEARCH_SCENE_PATH)));
        scene = new Scene(root);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Image image = new Image(ConfigResourceFXML.IMAGE);
        imageView.setImage(image);
    }
}
