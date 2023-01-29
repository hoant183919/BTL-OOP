package dataprocessingcontroller;

import datamanipulation.*;
import datamanipulation.datamanipulationimpl.*;
import entity.*;
import utils.configs.ConfigResourceData;

import java.util.List;

public class DataNguoiKeSuSingleton {

    private static DataNguoiKeSuSingleton dataNguoiKeSuSingleton;
    private List<CulturalFestival> culturalFestivals;
    private List<HistoricalDynasty> historicalDynasties;
    private List<HistoricalFigure> historicalFigures;
    private List<HistoricalSite> historicalSites;
    private List<HistoricEvent> historicEvents;
    private IDataManipulationCulturalFestival dataManipulationCulturalFestival;
    private IDataManipulationHistoricalDynasty dataManipulationHistoricalDynasty;
    private IDataManipulationHistoricalFigure dataManipulationHistoricalFigure;
    private IDataManipulationHistoricalSite dataManipulationHistoricalSite;
    private IDataManipulationHistoricEvent dataManipulationHistoricEvent;

    private DataNguoiKeSuSingleton() {
        dataManipulationCulturalFestival = new DataManipulationCulturalFestival();
        dataManipulationHistoricalDynasty = new DataManipulationHistoricalDynasty();
        dataManipulationHistoricalFigure = new DataManipulationHistoricalFigure();
        dataManipulationHistoricalSite = new DataManipulationHistoricalSite();
        dataManipulationHistoricEvent = new DataManipulationHistoricEvent();
        culturalFestivals = dataManipulationCulturalFestival.getDataCulturalFestivals(ConfigResourceData.RESERVE_DATA_NGUOIKESU_PATH);
        historicalDynasties = dataManipulationHistoricalDynasty.getDataHistoricalDynasties(ConfigResourceData.RESERVE_DATA_NGUOIKESU_PATH);
        historicalFigures = dataManipulationHistoricalFigure.getDataHistoricalFigures(ConfigResourceData.RESERVE_DATA_NGUOIKESU_PATH);
        historicalSites = dataManipulationHistoricalSite.getDataHistoricalSites(ConfigResourceData.RESERVE_DATA_NGUOIKESU_PATH);
        historicEvents = dataManipulationHistoricEvent.getDataHistoricEvents(ConfigResourceData.RESERVE_DATA_NGUOIKESU_PATH);
    }

    public static DataNguoiKeSuSingleton getInstance() {
        if (dataNguoiKeSuSingleton == null) {
            dataNguoiKeSuSingleton = new DataNguoiKeSuSingleton();
        }
        return dataNguoiKeSuSingleton;
    }

    public List<CulturalFestival> getCulturalFestivals() {
        return culturalFestivals;
    }

    public void setCulturalFestivals(List<CulturalFestival> culturalFestivals) {
        this.culturalFestivals = culturalFestivals;
        dataManipulationCulturalFestival.insertDataCulturalFestivals(ConfigResourceData.RESERVE_DATA_NGUOIKESU_PATH, culturalFestivals);
    }

    public List<HistoricalDynasty> getHistoricalDynasties() {
        return historicalDynasties;
    }

    public void setHistoricalDynasties(List<HistoricalDynasty> historicalDynasties) {
        this.historicalDynasties = historicalDynasties;
        dataManipulationHistoricalDynasty.insertDataHistoricalDynasties(ConfigResourceData.RESERVE_DATA_NGUOIKESU_PATH, historicalDynasties);
    }

    public List<HistoricalFigure> getHistoricalFigures() {
        return historicalFigures;
    }

    public void setHistoricalFigures(List<HistoricalFigure> historicalFigures) {
        this.historicalFigures = historicalFigures;
        dataManipulationHistoricalFigure.insertDataHistoricalFigures(ConfigResourceData.RESERVE_DATA_NGUOIKESU_PATH, historicalFigures);
    }

    public List<HistoricalSite> getHistoricalSites() {
        return historicalSites;
    }

    public void setHistoricalSites(List<HistoricalSite> historicalSites) {
        this.historicalSites = historicalSites;
        dataManipulationHistoricalSite.insertDataHistoricalSites(ConfigResourceData.RESERVE_DATA_NGUOIKESU_PATH, historicalSites);
    }

    public List<HistoricEvent> getHistoricEvents() {
        return historicEvents;
    }

    public void setHistoricEvents(List<HistoricEvent> historicEvents) {
        this.historicEvents = historicEvents;
        dataManipulationHistoricEvent.insertDataHistoricEvents(ConfigResourceData.RESERVE_DATA_NGUOIKESU_PATH, historicEvents);
    }
}