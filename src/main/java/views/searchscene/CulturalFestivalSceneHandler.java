package views.searchscene;

import entity.CulturalFestival;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;


public class CulturalFestivalSceneHandler extends BaseSceneHandler{
    @FXML
    Label thoiGianLabel;
    @FXML
    Label diaDiemLabel;
    @FXML
    Label thoiDiemToChucLanDauLabel;
    @FXML
    Label ghiChuLabel;

    public void setCulturalFestival(CulturalFestival culturalFestival) {
        tenLabel.setText(culturalFestival.getTen());
        thoiGianLabel.setText(culturalFestival.getThoiGian());
        diaDiemLabel.setText(culturalFestival.getDiaDiem());
        thoiDiemToChucLanDauLabel.setText(culturalFestival.getThoiDiemToChucLanDau());
        ghiChuLabel.setText(culturalFestival.getGhiChu());
        moTaLabel.setText(culturalFestival.getMoTa());
        nguonLabel.setText(culturalFestival.getNguonDuLieu());
        festivalRelationLabel.setText(culturalFestival.getRelatedToCulturalFestivals());
        figureRelationLabel.setText(culturalFestival.getRelatedToHistoricalFigures());
        siteRelationLabel.setText(culturalFestival.getRelatedToHistoricalSites());
        eventRelationLabel.setText(culturalFestival.getRelatedToHistoricEvents());
        dynastyRelationLabel.setText(culturalFestival.getRelatedToHistoricalDynasties());
        setLabel(tenLabel);
        setLabel(thoiGianLabel);
        setLabel(diaDiemLabel);
        setLabel(thoiDiemToChucLanDauLabel);
        setLabel(ghiChuLabel);
        setLabel(moTaLabel);
        setLabel(nguonLabel);
        setLabel(festivalRelationLabel);
        setLabel(figureRelationLabel);
        setLabel(siteRelationLabel);
        setLabel(eventRelationLabel);
        setLabel(dynastyRelationLabel);

    }
}
