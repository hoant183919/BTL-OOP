package views.searchscene;

import entity.HistoricEvent;
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

    public void setHistoricEvent(HistoricEvent historicEvent) {
        moTaLabel.setText(historicEvent.getMoTa());
        tenSuKienLabel.setText(historicEvent.getTen());
//        thoiGianLabel.setText(warEvent.getThoiGian());
//        thoiKyLabel.setText(warEvent.getThoiKy());
//        lucLuongLabel.setText(warEvent.getLucLuong());
//        doiPhuongLabel.setText(warEvent.getDoiPhuong());
//        ketQuaLabel.setText(warEvent.getKetQua());
    }
}
