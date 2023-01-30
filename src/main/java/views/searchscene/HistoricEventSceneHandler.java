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
        festivalRelationLabel.setText(historicEvent.getRelatedToCulturalFestivals());
        figureRelationLabel.setText(historicEvent.getRelatedToHistoricalFigures());
        siteRelationLabel.setText(historicEvent.getRelatedToHistoricalSites());
        eventRelationLabel.setText(historicEvent.getRelatedToHistoricEvents());
        dynastyRelationLabel.setText(historicEvent.getRelatedToHistoricalDynasties());
//        thoiGianLabel.setText(warEvent.getThoiGian());
//        thoiKyLabel.setText(warEvent.getThoiKy());
//        lucLuongLabel.setText(warEvent.getLucLuong());
//        doiPhuongLabel.setText(warEvent.getDoiPhuong());
//        ketQuaLabel.setText(warEvent.getKetQua());

        setLabel(festivalRelationLabel);
        setLabel(figureRelationLabel);
        setLabel(siteRelationLabel);
        setLabel(eventRelationLabel);
        setLabel(dynastyRelationLabel);
        setLabel(tenLabel);
        setLabel(moTaLabel);
        setLabel(nguonLabel);
        setLabel(thoiGianLabel);
        setLabel(thoiKyLabel);
        setLabel(lucLuongLabel);
        setLabel(ketQuaLabel);
        setLabel(doiPhuongLabel);
    }
}
