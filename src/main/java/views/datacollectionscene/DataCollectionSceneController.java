package views.datacollectionscene;

import datacollectioncontroller.DataCollectionController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import utils.HistoricType;
import utils.configs.ConfigResource;

import java.io.IOException;

public class DataCollectionSceneController {
    private Stage stage;
    private Scene scene;
    private HistoricType historicType;

    @FXML
    MenuItem wikipediaSource;
    @FXML
    MenuItem nguoiKeSuSource;
    @FXML
    Label statusLabel;

    // Set up Data Source
    @FXML
    public void setHistoricType(ActionEvent event) {
        MenuItem mi = (MenuItem) event.getSource();
        System.out.println("Menu item: " + mi.getText());
        if(mi == wikipediaSource) {
            historicType = HistoricType.WIKIPEDIA;
        }
        else if(mi == nguoiKeSuSource) {
            historicType = HistoricType.NGUOI_KE_SU;
        }
        statusLabel.setText("Ready");
    }
    // Start Data Collecting
    @FXML
    public void startDataCollecting(ActionEvent event) throws IOException {
        DataCollectionController dataCollectionController = new DataCollectionController();
        dataCollectionController.collectData();
        statusLabel.setText("Completed");

    }

    // Switch to Splash Scene
    @FXML
    public void backToSplashScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(("/SplashScene.fxml")));
        scene = new Scene(root);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }



}
