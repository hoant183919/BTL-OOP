package views.datacollectionscene;

import datacollectioncontroller.datacollectioncontrollerimpl.DataCollectionNguoiKeSuController;
import datacollectioncontroller.datacollectioncontrollerimpl.DataCollectionWikipediaController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import utils.HistoricType;
import utils.configs.ConfigResourceFXML;

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
    Label statusLabel = null;

    // Switch to Splash Scene
    @FXML
    public void backToSplashScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(ConfigResourceFXML.SPALSH_SCENE_PATH));
        scene = new Scene(root);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    // Set up Data Source
    @FXML
    public void setHistoricType(ActionEvent event) {
        MenuItem mi = (MenuItem) event.getSource();
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
    public void startDataCollecting(ActionEvent event) {
        Thread thread = new Thread() {
            public void run() {
                try {
                    // với wikipedia
                    if(historicType == HistoricType.WIKIPEDIA) {
                        DataCollectionWikipediaController dataCollectionWikipediaController = new DataCollectionWikipediaController();
                        dataCollectionWikipediaController.collectData();
                    }
                    //với nguoikesu
                    else if (historicType == HistoricType.NGUOI_KE_SU) {
                        DataCollectionNguoiKeSuController dataCollectionNguoiKeSuController = new DataCollectionNguoiKeSuController();
                        dataCollectionNguoiKeSuController.collectData();
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        thread.start();
        if(thread.isAlive()) {
            statusLabel.setText("Processing");
        } else statusLabel.setText("Completed");

    }

}
