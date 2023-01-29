package entity;

import java.util.HashMap;
import java.util.Map;

public class HistoricalFigure extends HistoricObject {
    public HistoricalFigure(int id) {
        super(id);
    }

    private String kieu;

    public String getKieu() {
        return kieu;
    }

    public void setKieu(String kieu) {
        this.kieu = kieu;
    }
}
