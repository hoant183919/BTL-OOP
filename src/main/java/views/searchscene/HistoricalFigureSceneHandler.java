package views.searchscene;

import entity.HistoricalFigure;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HistoricalFigureSceneHandler extends BaseSceneHandler {
    @FXML
    Label tenHuyLabel;
    @FXML
    Label tenChuHanLabel;
    @FXML
    Label namSinhMatLabel;
    @FXML
    Label mieuHieuLabel;
    @FXML
    Label thuyHieuLabel;
    @FXML
    Label nienHieuLabel;
    @FXML
    Label vaiTroLabel;
    @FXML
    Label theThuLabel;
    @FXML
    Label triViLabel;

public void setHistoricalFigure(HistoricalFigure historicalFigure) {
    moTaLabel.setText(historicalFigure.getMoTa());
    tenLabel.setText(historicalFigure.getTen());
    nguonLabel.setText(historicalFigure.getNguonDuLieu());
    festivalRelationLabel.setText(historicalFigure.getRelatedToCulturalFestivals().toString());
    figureRelationLabel.setText(historicalFigure.getRelatedToHistoricalFigures().toString());
    siteRelationLabel.setText(historicalFigure.getRelatedToHistoricalSites().toString());
    eventRelationLabel.setText(historicalFigure.getRelatedToHistoricEvents().toString());
    dynastyRelationLabel.setText(historicalFigure.getRelatedToHistoricalDynasties().toString());
//    tenHuyLabel.setText(dominator.getTenHuy());
//    tenChuHanLabel.setText(dominator.getTenChuHan());
//    namSinhMatLabel.setText(dominator.getNamSinhMat());
//    mieuHieuLabel.setText(dominator.getMieuHieu());
//    thuyHieuLabel.setText(dominator.getThuyHieu());
//    nienHieuLabel.setText(dominator.getNienHieu());
//    vaiTroLabel.setText(dominator.getVaiTro());
//    theThuLabel.setText(dominator.getTheThu());
//    triViLabel.setText(dominator.getTriVi());
}



}
