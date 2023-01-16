package views.searchscene;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


public class SearchSceneController {

    private Stage stage;
    private Scene scene;

    // Switch to Splash Scene
    @FXML
    public void backToSplashScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(("/SplashScene.fxml")));
        scene = new Scene(root);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    // Switch Scene
    @FXML
    public void switchScreen(ActionEvent event) throws IOException {
        if(scene == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Luu y");
            alert.setContentText("Hay chon the loai tim kiem");
            alert.show();
        }
        else {
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }

    }
    // Set Historical Dynasty Scene
    @FXML
    private void setHDS(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/searchscene/HistoricalDynastyScene.fxml"));
        scene = new Scene(root);
    }
    // Set Cultural Festival Scene
    @FXML
    public void setCFS(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/searchscene/CulturalFestivalScene.fxml"));
        scene = new Scene(root);
    }
    // Set Dominator Scene
    @FXML
    public void setDS(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/searchscene/DominatorScene.fxml"));
        scene = new Scene(root);
    }
    // Set Historical Event Scene
    @FXML
    public void setHES(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/searchscene/HistoricEventScene.fxml"));
        scene = new Scene(root);
    }
    // Set Historical Figure Scene
    @FXML
    public void setHFS(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/searchscene/HistoricalFigureScene.fxml"));
        scene = new Scene(root);
    }
    // Set Historical Site Scene
    @FXML
    public void setHSS(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/searchscene/HistoricalSiteScene.fxml"));
        scene = new Scene(root);
    }
    // Set War Event Scene
    @FXML
    public void setWES(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/searchscene/WarEventScene.fxml"));
        scene = new Scene(root);
    }

    @FXML
    TextField contentSearch;



}