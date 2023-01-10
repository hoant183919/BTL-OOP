package views.searchscene;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Stage;



public class HistoricalDynastySceneController extends BaseSceneController {
    @FXML
    Label tenTrieuDaiLabel;
    @FXML
    Label kinhDoLabel;
    Stage stage;



    SearchSceneController searchSceneController = new SearchSceneController();

    @FXML
    public void alertInput(ActionEvent event) {
        String input = searchSceneController.contentSearch.getText();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(input);
        alert.show();



//    ConvertData convertData = new ConvertData();
//    public void contentLabel(String input) throws Exception {
//        input = searchSceneController.contentSearch.getText();

//        convertData.dataSummary("D:\\BTL-OOP\\src\\main\\java\\data\\reservedata\\wikipedia\\historicaldynasties.json");
//        if (Arrays.asList(convertData.array).contains(input)) {
//
//        }

    }

}
