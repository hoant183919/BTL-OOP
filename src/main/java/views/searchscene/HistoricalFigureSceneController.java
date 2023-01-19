package views.searchscene;

import entity.Dominator;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HistoricalFigureSceneController extends BaseSceneController {
    @FXML
    Label tenLabel;
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

public void setHistoricalFigure(Dominator dominator) {
    idLabel.setText(String.valueOf(dominator.getId()));
    moTaLabel.setText(dominator.getMoTa());
    tenLabel.setText(dominator.getTen());
    tenHuyLabel.setText(dominator.getTenHuy());
    tenChuHanLabel.setText(dominator.getTenChuHan());
    namSinhMatLabel.setText(dominator.getNamSinhMat());
    mieuHieuLabel.setText(dominator.getMieuHieu());
    thuyHieuLabel.setText(dominator.getThuyHieu());
    nienHieuLabel.setText(dominator.getNienHieu());
    vaiTroLabel.setText(dominator.getVaiTro());
    theThuLabel.setText(dominator.getTheThu());
    triViLabel.setText(dominator.getTriVi());
}



}
