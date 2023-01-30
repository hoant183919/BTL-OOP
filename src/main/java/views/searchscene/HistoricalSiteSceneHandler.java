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
        festivalRelationLabel.setText(historicalSite.getRelatedToCulturalFestivals());
        figureRelationLabel.setText(historicalSite.getRelatedToHistoricalFigures());
        siteRelationLabel.setText(historicalSite.getRelatedToHistoricalSites());
        eventRelationLabel.setText(historicalSite.getRelatedToHistoricEvents());
        dynastyRelationLabel.setText(historicalSite.getRelatedToHistoricalDynasties());

        setLabel(festivalRelationLabel);
        setLabel(figureRelationLabel);
        setLabel(siteRelationLabel);
        setLabel(eventRelationLabel);
        setLabel(dynastyRelationLabel);
        setLabel(tenLabel);
        setLabel(diaDiemLabel);
        setLabel(namCNLabel);
        setLabel(mieuTaLabel);
        setLabel(ghiChuLabel);
        setLabel(moTaLabel);
        setLabel(nguonLabel);
    }
}
