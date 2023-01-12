package views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import views.datasummaryscene.DataSummarySceneController;

import java.io.IOException;

public class SplashSceneController {
    private Stage stage;
    private Scene scene;

    // Switch to Search Scene
    @FXML
    public void switchToSearchScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(("/searchscene/SearchScene.fxml")));
        scene = new Scene(root);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    // Switch to DataCollection Scene
    @FXML
    public void switchToDataCollectionScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(("/datacollectionscene/DataCollectionScene.fxml")));
        scene = new Scene(root);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    // Switch to DataSummary Scene
    @FXML
    public void switchToDataSummaryScene(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource(("/datasummaryscene/DataSummaryScene.fxml")));
        scene = new Scene(root);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }


}
