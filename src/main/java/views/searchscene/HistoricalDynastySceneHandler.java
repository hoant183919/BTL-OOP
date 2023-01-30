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
        festivalRelationLabel.setText(historicalDynasty.getRelatedToCulturalFestivals());
        figureRelationLabel.setText(historicalDynasty.getRelatedToHistoricalFigures());
        siteRelationLabel.setText(historicalDynasty.getRelatedToHistoricalSites());
        eventRelationLabel.setText(historicalDynasty.getRelatedToHistoricEvents());
        dynastyRelationLabel.setText(historicalDynasty.getRelatedToHistoricalDynasties());

        setLabel(festivalRelationLabel);
        setLabel(figureRelationLabel);
        setLabel(siteRelationLabel);
        setLabel(eventRelationLabel);
        setLabel(dynastyRelationLabel);
        setLabel(tenLabel);
        setLabel(kinhDoLabel);
        setLabel(moTaLabel);
        setLabel(nguonLabel);

    }


}
