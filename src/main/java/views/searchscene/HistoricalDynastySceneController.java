package views.searchscene;

import entity.HistoricalDynasty;
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

    public  void setHistoricalDynasty(HistoricalDynasty historicalDynasty) {
        tenTrieuDaiLabel.setText(historicalDynasty.getTen());
        kinhDoLabel.setText(historicalDynasty.getKinhDo());
        moTaLabel.setText(historicalDynasty.getMoTa());
    }


}
