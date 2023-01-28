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


public class DataCollectionSceneHandler {
    private Stage stage;
    private Scene scene;
    private HistoricType historicType;

    @FXML
    MenuItem wikipediaSource;
    @FXML
    MenuItem nguoiKeSuSource;
    @FXML
    Label statusLabel = null;
    @FXML
    ProgressBar progressBar;

    // Switch to Splash Scene
    @FXML
    public void backToSplashScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(ConfigResourceFXML.SPALSH_SCENE_PATH));
        scene = new Scene(root);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
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
    Thread thread = new Thread(task);

    // Start Data Collecting
    @FXML
    public void startDataCollecting(ActionEvent event) {
        if (historicType == HistoricType.NGUOI_KE_SU) {
            statusLabel.setText("Nguồn: Người kể sử");
        } else if (historicType == HistoricType.WIKIPEDIA) {
            statusLabel.setText("Nguồn: Wikipedia");
        }
        progressBar.setDisable(false);
        progressBar.setOpacity(1);
        thread.start();
        progressBar.progressProperty().bind(task.progressProperty());
        task.setOnSucceeded(WorkerStateEvent -> {
            statusLabel.setText("Completed");
            progressBar.setDisable(true);
            progressBar.setOpacity(0);
        });

    }
}
