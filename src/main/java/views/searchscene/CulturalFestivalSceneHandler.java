package views.searchscene;

import entity.CulturalFestival;
import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class CulturalFestivalSceneHandler extends BaseSceneHandler {
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
    }

}
