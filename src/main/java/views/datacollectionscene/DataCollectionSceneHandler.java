package views.datacollectionscene;

import datacollectioncontroller.datacollectioncontrollerimpl.DataCollectionNguoiKeSuController;
import datacollectioncontroller.datacollectioncontrollerimpl.DataCollectionWikipediaController;
import dataprocessingcontroller.DataSingleton;
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
    @FXML
    Button cancelButton;

    @FXML
    public void backToSplashScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(ConfigResourceFXML.SPLASH_SCENE_PATH));
        scene = new Scene(root);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    public void setHistoricType(ActionEvent event) {
        MenuItem mi = (MenuItem) event.getSource();
        if (mi == wikipediaSource) {
            historicType = HistoricType.WIKIPEDIA;
        } else if (mi == nguoiKeSuSource) {
            historicType = HistoricType.NGUOI_KE_SU;
        }
        statusLabel.setText("Ready");
    }

    Task<Void> wikipediaTask = new Task<Void>() {
        @Override
        protected Void call() throws Exception {
            DataCollectionWikipediaController dataCollectionWikipediaController = new DataCollectionWikipediaController();
            dataCollectionWikipediaController.collectData();
            return null;
        }
    };
    Task<Void> nguoiKeSuTask = new Task<Void>() {
        @Override
        protected Void call() throws Exception {
            DataCollectionNguoiKeSuController dataCollectionNguoiKeSuController = new DataCollectionNguoiKeSuController();
            dataCollectionNguoiKeSuController.collectData();
            return null;
        }
    };
    Thread nguoiKeSuThread = new Thread(nguoiKeSuTask);
    Thread wikipediaThread = new Thread(wikipediaTask);

    @FXML
    public void startDataCollecting(ActionEvent event) {
        progressBar.setDisable(false);
        progressBar.setOpacity(1);
        cancelButton.setDisable(false);
        cancelButton.setVisible(true);
        progressBar.setVisible(true);
        cancelButton.setOpacity(1);
        if (historicType == HistoricType.NGUOI_KE_SU) {
            nguoiKeSuThread.start();
            statusLabel.setText("Nguồn: Người kể sử");
            progressBar.progressProperty().bind(nguoiKeSuTask.progressProperty());
            nguoiKeSuTask.setOnSucceeded(WorkerStateEvent -> {
                statusLabel.setText("Completed");
                progressBar.progressProperty().unbind();
                progressBar.setDisable(true);
                progressBar.setOpacity(0);
                DataSingleton.getInstance().updateData();
            });
        } else if (historicType == HistoricType.WIKIPEDIA) {
            statusLabel.setText("Nguồn: Wikipedia");
            wikipediaThread.start();
            progressBar.progressProperty().bind(wikipediaTask.progressProperty());
            wikipediaTask.setOnSucceeded(WorkerStateEvent -> {
                statusLabel.setText("Completed");
                progressBar.progressProperty().unbind();
                progressBar.setDisable(true);
                progressBar.setOpacity(0);
                DataSingleton.getInstance().updateData();
            });
        } else if (historicType == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            cancelButton.setVisible(false);
            progressBar.setVisible(false);
            alert.setTitle("Lưu ý");
            alert.setContentText("Hãy chọn nguồn dữ liệu");
            alert.show();
        }
    }

    @FXML
    public void cancelDataCollecting(ActionEvent event) {
        if (wikipediaTask.isRunning()) {
            wikipediaTask.cancel();
        } else if (nguoiKeSuTask.isRunning()) {
            nguoiKeSuTask.cancel();
        }
        nguoiKeSuThread = new Thread(nguoiKeSuTask);
        wikipediaThread = new Thread(wikipediaTask);
        cancelButton.setVisible(false);
        statusLabel.setText("Đã hủy thu thập");
        progressBar.progressProperty().unbind();
        progressBar.setDisable(true);
        progressBar.setOpacity(0);

    }
}