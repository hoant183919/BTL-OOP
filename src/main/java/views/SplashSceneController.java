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

import java.io.IOException;

public class SplashSceneController {
    private Stage stage;
    private Scene scene;

    @FXML
    SplitMenuButton searchButton;


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

    // Switch to Search Scene
    @FXML
    public void switchToSearchScreen(ActionEvent event) throws IOException {
        if(scene == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Lưu ý");
            alert.setContentText("Hãy chọn thể loại cần tìm kiếm");
            alert.show();
        }  else {
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }

    }
    // Set Historical Dynasty Scene
    @FXML
    private void setHDS(ActionEvent event) throws IOException {
        searchButton.setText("Tìm kiếm triều đại lịch sử");
        Parent root = FXMLLoader.load(getClass().getResource("/searchscene/HistoricalDynastyScene.fxml"));
        scene = new Scene(root);
    }
    // Set Cultural Festival Scene
    @FXML
    public void setCFS(ActionEvent event) throws IOException {
        searchButton.setText("Tìm kiếm lễ hội văn hóa");
        Parent root = FXMLLoader.load(getClass().getResource("/searchscene/CulturalFestivalScene.fxml"));
        scene = new Scene(root);
    }
    // Set Historical Event Scene
    @FXML
    public void setHES(ActionEvent event) throws IOException {
        searchButton.setText("Tìm kiếm sự kiện lịch sử");
        Parent root = FXMLLoader.load(getClass().getResource("/searchscene/HistoricEventScene.fxml"));
        scene = new Scene(root);
    }
    // Set Historical Figure Scene
    @FXML
    public void setHFS(ActionEvent event) throws IOException {
        searchButton.setText("Tìm kiếm nhân vật lịch sử");
        Parent root = FXMLLoader.load(getClass().getResource("/searchscene/HistoricalFigureScene.fxml"));
        scene = new Scene(root);
    }
    // Set Historical Site Scene
    @FXML
    public void setHSS(ActionEvent event) throws IOException {
        searchButton.setText("Tìm kiếm di tích lịch sử");
        Parent root = FXMLLoader.load(getClass().getResource("/searchscene/HistoricalSiteScene.fxml"));
        scene = new Scene(root);
    }

}
