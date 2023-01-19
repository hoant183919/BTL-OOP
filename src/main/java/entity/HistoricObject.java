package entity;

import org.json.simple.JSONObject;

import java.util.List;

public abstract class HistoricObject extends BaseEntity{

    public HistoricObject(int id) {
        super(id);
    }

    private String ten;
    private String moTa;
    private String kieu;
    private List<String> relatedToCulturalFestivals;
    private List<String> relatedToHistoricalDynasties;
    private List<String> relatedToHistoricalFigures;
    private List<String> relatedToHistoricalSites;
    private List<String> relatedToHistoricEvents;

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

    public String getKieu() {
        return kieu;
    }

    public void setKieu(String kieu) {
        this.kieu = kieu;
    }

    public List<String> getRelatedToCulturalFestivals() {
        return relatedToCulturalFestivals;
    }

    public void setRelatedToCulturalFestivals(List<String> relatedToCulturalFestivals) {
        this.relatedToCulturalFestivals = relatedToCulturalFestivals;
    }

    public List<String> getRelatedToHistoricalDynasties() {
        return relatedToHistoricalDynasties;
    }

    public void setRelatedToHistoricalDynasties(List<String> relatedToHistoricalDynasties) {
        this.relatedToHistoricalDynasties = relatedToHistoricalDynasties;
    }

    public List<String> getRelatedToHistoricalFigures() {
        return relatedToHistoricalFigures;
    }

    public void setRelatedToHistoricalFigures(List<String> relatedToHistoricalFigures) {
        this.relatedToHistoricalFigures = relatedToHistoricalFigures;
    }

    public List<String> getRelatedToHistoricalSites() {
        return relatedToHistoricalSites;
    }

    public void setRelatedToHistoricalSites(List<String> relatedToHistoricalSites) {
        this.relatedToHistoricalSites = relatedToHistoricalSites;
    }

    public List<String> getRelatedToHistoricEvents() {
        return relatedToHistoricEvents;
    }

    public void setRelatedToHistoricEvents(List<String> relatedToHistoricEvents) {
        this.relatedToHistoricEvents = relatedToHistoricEvents;
    }

    public JSONObject toJSONObject(){
        return null;
    }
}
