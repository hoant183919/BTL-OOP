package views.datacollectionscene;

import datacollectioncontroller.datacollectioncontrollerimpl.DataCollectionNguoiKeSuController;
import datacollectioncontroller.datacollectioncontrollerimpl.DataCollectionWikipediaController;
import javafx.concurrent.Task;

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


public class DataCollectionSceneController{
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
        statusLabel.setText("Processing");
        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {

                if (historicType == HistoricType.WIKIPEDIA) {
                    DataCollectionWikipediaController dataCollectionWikipediaController = new DataCollectionWikipediaController();
                    dataCollectionWikipediaController.collectData();
                }
                else if (historicType == HistoricType.NGUOI_KE_SU) {
                    DataCollectionNguoiKeSuController dataCollectionNguoiKeSuController = new DataCollectionNguoiKeSuController();
                    dataCollectionNguoiKeSuController.collectData();
                } else if (historicType == null) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Lưu ý");
                    alert.setContentText("Hãy chọn nguồn dữ liệu");
                    alert.show();
                }
                return null;
            }
        };
        task.setOnSucceeded(WorkerStateEvent -> {
            statusLabel.setText("Completed");
        });
        new Thread(task).start();

        }

}
