package entity;

import org.json.simple.JSONObject;

import java.util.List;

public abstract class HistoricObject extends BaseEntity{

    public HistoricObject(int id) {
        super(id);
    }

    private String ten;
    private String moTa;
    private String nguonDuLieu;
    private String relatedToCulturalFestivals;
    private String relatedToHistoricalDynasties;
    private String relatedToHistoricalFigures;
    private String relatedToHistoricalSites;
    private String relatedToHistoricEvents;

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getNguonDuLieu() {
        return nguonDuLieu;
    }

    public void setNguonDuLieu(String nguonDuLieu) {
        this.nguonDuLieu = nguonDuLieu;
    }

    public String getRelatedToCulturalFestivals() {
        return relatedToCulturalFestivals;
    }

    public void setRelatedToCulturalFestivals(String relatedToCulturalFestivals) {
        this.relatedToCulturalFestivals = relatedToCulturalFestivals;
    }

    public String getRelatedToHistoricalDynasties() {
        return relatedToHistoricalDynasties;
    }

    public void setRelatedToHistoricalDynasties(String relatedToHistoricalDynasties) {
        this.relatedToHistoricalDynasties = relatedToHistoricalDynasties;
    }

    public String getRelatedToHistoricalFigures() {
        return relatedToHistoricalFigures;
    }

    public void setRelatedToHistoricalFigures(String relatedToHistoricalFigures) {
        this.relatedToHistoricalFigures = relatedToHistoricalFigures;
    }

    public String getRelatedToHistoricalSites() {
        return relatedToHistoricalSites;
    }

    public void setRelatedToHistoricalSites(String relatedToHistoricalSites) {
        this.relatedToHistoricalSites = relatedToHistoricalSites;
    }

    public String getRelatedToHistoricEvents() {
        return relatedToHistoricEvents;
    }

    public void setRelatedToHistoricEvents(String relatedToHistoricEvents) {
        this.relatedToHistoricEvents = relatedToHistoricEvents;
    }

    public JSONObject toJSONObject(){
        return null;
    }
}
