package entity;

import java.awt.*;

public class HistoricEvent extends HistoricObject {
    public HistoricEvent(int id) {
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
