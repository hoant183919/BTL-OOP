package views.datasummaryscene;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class DataSummarySceneController implements Initializable {
    private Stage stage;
    private Scene scene;
    @FXML
    ListView<Object> listViewWikipedia;
    @FXML
    ListView<Object> listViewNguoiKeSu;

    @FXML
    public void backtoSplashScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(("/SplashScene.fxml")));
        scene = new Scene(root);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        String[] wikipediaData = {
                "D:\\BTL-OOP\\src\\main\\java\\data\\reservedata\\wikipedia\\historicaldynasties.json",
                "D:\\BTL-OOP\\src\\main\\java\\data\\reservedata\\wikipedia\\historicalfigures.json",
                "D:\\BTL-OOP\\src\\main\\java\\data\\reservedata\\wikipedia\\culturalfestivals.json",
                "D:\\BTL-OOP\\src\\main\\java\\data\\reservedata\\wikipedia\\historicalsites.json",
                "D:\\BTL-OOP\\src\\main\\java\\data\\reservedata\\wikipedia\\historicevents.json"

        };
        try {
            listViewWikipedia.setItems(dataSummary(wikipediaData));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public ObservableList<Object> dataSummary(String[] filePaths) throws IOException {
        List<Object> objectList = new ArrayList<>();
        for (String filePath: filePaths) {
            String dataSummary = new String(Files.readAllBytes(Paths.get(filePath)));
            JSONArray array = new JSONArray(dataSummary);
            for (int i = 0; i < array.length(); i++) {
                JSONObject object = array.getJSONObject(i);
                objectList.add(object);
            }
        }
        ObservableList<Object> observableList = FXCollections.observableList(objectList);
        return observableList;
    }

}



