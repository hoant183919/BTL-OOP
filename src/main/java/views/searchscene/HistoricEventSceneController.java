package views.searchscene;

import entity.WarEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HistoricEventSceneController extends BaseSceneController {
    @FXML
    Label tenSuKienLabel;
    @FXML
    Label thoiGianLabel;
    @FXML
    Label thoiKyLabel;
    @FXML
    Label lucLuongLabel;
    @FXML
    Label doiPhuongLabel;
    @FXML
    Label ketQuaLabel;

    public void setHistoricEvent(WarEvent warEvent) {
        idLabel.setText(String.valueOf(warEvent.getId()));
        moTaLabel.setText(warEvent.getMoTa());
        tenSuKienLabel.setText(warEvent.getTen());
        thoiGianLabel.setText(warEvent.getThoiGian());
        thoiKyLabel.setText(warEvent.getThoiKy());
        lucLuongLabel.setText(warEvent.getLucLuong());
        doiPhuongLabel.setText(warEvent.getDoiPhuong());
        ketQuaLabel.setText(warEvent.getKetQua());
    }
}
