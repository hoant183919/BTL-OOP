package views.searchscene;

import entity.HistoricEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HistoricEventSceneHandler extends BaseSceneHandler {
    @FXML
    Label thoiGianLabel;
    @FXML
    Label thoiKyLabel;
    @FXML
    Label lucLuongLabel;
    @FXML
    Label doiPhuongLabel;
    @FXML
    Label ketQuaLabel;

    public void setHistoricEvent(HistoricEvent historicEvent) {
        moTaLabel.setText(historicEvent.getMoTa());
        tenLabel.setText(historicEvent.getTen());
        nguonLabel.setText(historicEvent.getNguonDuLieu());
        festivalRelationLabel.setText(historicEvent.getRelatedToCulturalFestivals().toString());
        figureRelationLabel.setText(historicEvent.getRelatedToHistoricalFigures().toString());
        siteRelationLabel.setText(historicEvent.getRelatedToHistoricalSites().toString());
        eventRelationLabel.setText(historicEvent.getRelatedToHistoricEvents().toString());
        dynastyRelationLabel.setText(historicEvent.getRelatedToHistoricalDynasties().toString());
//        thoiGianLabel.setText(warEvent.getThoiGian());
//        thoiKyLabel.setText(warEvent.getThoiKy());
//        lucLuongLabel.setText(warEvent.getLucLuong());
//        doiPhuongLabel.setText(warEvent.getDoiPhuong());
//        ketQuaLabel.setText(warEvent.getKetQua());
    }
}
