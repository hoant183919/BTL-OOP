package views.searchscene;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class BaseSceneHandler {
    @FXML
    Label moTaLabel;
    @FXML
    Label tenLabel;
    @FXML
    Label nguonLabel;
    @FXML
    Label figureRelationLabel;
    @FXML
    Label siteRelationLabel;
    @FXML
    Label festivalRelationLabel;
    @FXML
    Label dynastyRelationLabel;
    @FXML
    Label eventRelationLabel;
    public void setLabel(Label label) {
        if(label.getText() == "" || label.getText() == null) {
            label.setText("Không có");
        }
    }

}

