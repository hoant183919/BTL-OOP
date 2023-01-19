package views.searchscene;

import entity.CulturalFestival;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;



public class CulturalFestivalSceneController extends BaseSceneController{
    @FXML
    Label tenLabel;
    @FXML
    Label thoiGianLabel;
    @FXML
    Label diaDiemLabel;
    @FXML
    Label thoiDiemToChucLanDauLabel;
    @FXML
    Label ghiChuLabel;

    public void setCulturalFestival(CulturalFestival culturalFestival) {
        idLabel.setText(String.valueOf(culturalFestival.getId()));
        tenLabel.setText(culturalFestival.getTen());
        thoiGianLabel.setText(culturalFestival.getThoiGian());
        diaDiemLabel.setText(culturalFestival.getDiaDiem());
        thoiDiemToChucLanDauLabel.setText(culturalFestival.getThoiDiemToChucLanDau());
        ghiChuLabel.setText(culturalFestival.getGhiChu());
        moTaLabel.setText(culturalFestival.getMoTa());
    }

}
