package views.searchscene;

import entity.HistoricalSite;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HistoricalSiteSceneHandler extends BaseSceneHandler {
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
        nguonLabel.setText(historicalSite.getNguonDuLieu());
        festivalRelationLabel.setText(historicalSite.getRelatedToCulturalFestivals().toString());
        figureRelationLabel.setText(historicalSite.getRelatedToHistoricalFigures().toString());
        siteRelationLabel.setText(historicalSite.getRelatedToHistoricalSites().toString());
        eventRelationLabel.setText(historicalSite.getRelatedToHistoricEvents().toString());
        dynastyRelationLabel.setText(historicalSite.getRelatedToHistoricalDynasties().toString());
    }
}
