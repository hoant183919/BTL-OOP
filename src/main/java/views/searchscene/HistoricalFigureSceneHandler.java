package views.searchscene;

import entity.Dominator;
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
    festivalRelationLabel.setText(historicalFigure.getRelatedToCulturalFestivals());
    figureRelationLabel.setText(historicalFigure.getRelatedToHistoricalFigures());
    siteRelationLabel.setText(historicalFigure.getRelatedToHistoricalSites());
    eventRelationLabel.setText(historicalFigure.getRelatedToHistoricEvents());
    dynastyRelationLabel.setText(historicalFigure.getRelatedToHistoricalDynasties());
//    tenHuyLabel.setText(dominator.getTenHuy());
//    tenChuHanLabel.setText(dominator.getTenChuHan());
//    namSinhMatLabel.setText(dominator.getNamSinhMat());
//    mieuHieuLabel.setText(dominator.getMieuHieu());
//    thuyHieuLabel.setText(dominator.getThuyHieu());
//    nienHieuLabel.setText(dominator.getNienHieu());
//    vaiTroLabel.setText(dominator.getVaiTro());
//    theThuLabel.setText(dominator.getTheThu());
//    triViLabel.setText(dominator.getTriVi());

    setLabel(festivalRelationLabel);
    setLabel(figureRelationLabel);
    setLabel(siteRelationLabel);
    setLabel(eventRelationLabel);
    setLabel(dynastyRelationLabel);
    setLabel(tenLabel);
    setLabel(moTaLabel);
    setLabel(nguonLabel);
    setLabel(tenHuyLabel);
    setLabel(tenChuHanLabel);
    setLabel(namSinhMatLabel);
    setLabel(mieuHieuLabel);
    setLabel(thuyHieuLabel);
    setLabel(nienHieuLabel);
    setLabel(vaiTroLabel);
    setLabel(theThuLabel);
    setLabel(triViLabel);


}



}
