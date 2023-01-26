package views.searchscene;

import entity.HistoricalSite;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HistoricalSiteSceneController extends BaseSceneController {
    @FXML
    Label tenLabel;
    @FXML
    Label diaDiemLabel;
    @FXML
    Label namCNLabel;
    @FXML
    Label mieuTaLabel;
    @FXML
    Label ghiChuLabel;

    public void setHistoricalSite(HistoricalSite historicalSite) {
        tenLabel.setText(historicalSite.getTen());
        diaDiemLabel.setText(historicalSite.getDiaDiem());
        namCNLabel.setText(historicalSite.getNamCN());
        mieuTaLabel.setText(historicalSite.getMieuTa());
        ghiChuLabel.setText(historicalSite.getGhiChu());
        moTaLabel.setText(historicalSite.getMoTa());
    }
}
