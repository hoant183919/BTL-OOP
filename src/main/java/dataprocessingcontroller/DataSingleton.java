package dataprocessingcontroller;

import entity.*;

import java.util.List;

public class DataSingleton {
    private static DataSingleton dataSingleton;
    private List<CulturalFestival> culturalFestivals;
    private List<HistoricalDynasty> historicalDynasties;
    private List<HistoricalFigure> historicalFigures;
    private List<HistoricalSite> historicalSites;
    private List<HistoricEvent> historicEvents;
    private SummaryController summaryController;

    private DataSingleton() {
        summaryController = new SummaryController();
        culturalFestivals = summaryController.getAllCulturalFestival();
        historicalDynasties = summaryController.getAllHistoricalDynasty();
        historicalFigures = summaryController.getAllHistoricalFigure();
        historicalSites = summaryController.getAllHistoricalSite();
        historicEvents = summaryController.getAllHistoricEvent();
    }

    public static DataSingleton getInstance() {
        if (dataSingleton == null) {
            dataSingleton = new DataSingleton();
        }
        return dataSingleton;
    }

    public List<CulturalFestival> getCulturalFestivals() {
        return culturalFestivals;
    }

    public void setCulturalFestivals(List<CulturalFestival> culturalFestivals) {
        this.culturalFestivals = culturalFestivals;
    }

    public List<HistoricalDynasty> getHistoricalDynasties() {
        return historicalDynasties;
    }

    public void setHistoricalDynasties(List<HistoricalDynasty> historicalDynasties) {
        this.historicalDynasties = historicalDynasties;
    }

    public List<HistoricalFigure> getHistoricalFigures() {
        return historicalFigures;
    }

    public void setHistoricalFigures(List<HistoricalFigure> historicalFigures) {
        this.historicalFigures = historicalFigures;
    }

    public List<HistoricalSite> getHistoricalSites() {
        return historicalSites;
    }

    public void setHistoricalSites(List<HistoricalSite> historicalSites) {
        this.historicalSites = historicalSites;
    }

    public List<HistoricEvent> getHistoricEvents() {
        return historicEvents;
    }

    public void setHistoricEvents(List<HistoricEvent> historicEvents) {
        this.historicEvents = historicEvents;
    }
}
