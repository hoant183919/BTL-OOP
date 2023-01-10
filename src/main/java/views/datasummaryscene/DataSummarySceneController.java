package views.datasummaryscene;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

import java.io.IOException;

public class DataSummarySceneController {
    private Stage stage;
    private Scene scene;
    @FXML
    Label wikipediaLabel;

    public DataSummarySceneController() throws Exception {
    }

    @FXML
    public void backtoSplashScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(("/SplashScene.fxml")));
        scene = new Scene(root);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    public void setWikipediaLabel() throws Exception {
        ConvertData convertData = new ConvertData();
        String result;
//        convertData.historicalDynastyDataSummary("D:\\BTL-OOP\\src\\main\\java\\data\\reservedata\\wikipedia\\historicaldynasties.json");
//        convertData.culturalFestivalDataSummary("D:\\BTL-OOP\\src\\main\\java\\data\\reservedata\\wikipedia\\culturalfestivals.json");
//        convertData.dominatorDataSummary("D:\\BTL-OOP\\src\\main\\java\\data\\reservedata\\wikipedia\\historicalfigures.json");
//        convertData.warEventDataSummary("D:\\BTL-OOP\\src\\main\\java\\data\\reservedata\\wikipedia\\historicevents.json");
        result =convertData.historicalSiteDataSummary("D:\\BTL-OOP\\src\\main\\java\\data\\reservedata\\wikipedia\\historicalsites.json");
        wikipediaLabel.setText(result);
    }

}
