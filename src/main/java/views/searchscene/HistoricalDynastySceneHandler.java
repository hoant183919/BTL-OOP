package views.searchscene;

import entity.HistoricalDynasty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class HistoricalDynastySceneHandler extends BaseSceneHandler {
    @FXML
    Label kinhDoLabel;

    public  void setHistoricalDynasty(HistoricalDynasty historicalDynasty) {
        tenLabel.setText(historicalDynasty.getTen());
        kinhDoLabel.setText(historicalDynasty.getKinhDo());
        moTaLabel.setText(historicalDynasty.getMoTa());
        nguonLabel.setText(historicalDynasty.getNguonDuLieu());
        festivalRelationLabel.setText(historicalDynasty.getRelatedToCulturalFestivals().toString());
        figureRelationLabel.setText(historicalDynasty.getRelatedToHistoricalFigures().toString());
        siteRelationLabel.setText(historicalDynasty.getRelatedToHistoricalSites().toString());
        eventRelationLabel.setText(historicalDynasty.getRelatedToHistoricEvents().toString());
        dynastyRelationLabel.setText(historicalDynasty.getRelatedToHistoricalDynasties().toString());
    }


}
