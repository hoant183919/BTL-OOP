package dataprocessingcontroller;

import common.exception.HistoricalDynastyDataCollectionException;
import datamanipulation.*;
import datamanipulation.datamanipulationimpl.*;
import entity.*;
import utils.configs.ConfigResourceData;

import java.util.List;

public class DataSingleton {
    private static DataSingleton dataSingleton;

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

    private DataSingleton() {
        updateData();
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

    public List<HistoricalDynasty> getHistoricalDynasties() {
        return historicalDynasties;
    }

    public List<HistoricalFigure> getHistoricalFigures() {
        return historicalFigures;
    }

    public List<HistoricalSite> getHistoricalSites() {
        return historicalSites;
    }

    public List<HistoricEvent> getHistoricEvents() {
        return historicEvents;
    }

    public void updateData() {
        dataManipulationCulturalFestival = new DataManipulationCulturalFestival();
        dataManipulationHistoricalDynasty = new DataManipulationHistoricalDynasty();
        dataManipulationHistoricalFigure = new DataManipulationHistoricalFigure();
        dataManipulationHistoricalSite = new DataManipulationHistoricalSite();
        dataManipulationHistoricEvent = new DataManipulationHistoricEvent();

        culturalFestivals = dataManipulationCulturalFestival.getDataCulturalFestivals(ConfigResourceData.RESERVE_DATA_WIKIPEDIA_PATH);
        historicalDynasties = dataManipulationHistoricalDynasty.getDataHistoricalDynasties(ConfigResourceData.RESERVE_DATA_WIKIPEDIA_PATH);
        historicalFigures = dataManipulationHistoricalFigure.getDataHistoricalFigures(ConfigResourceData.RESERVE_DATA_WIKIPEDIA_PATH);
        historicalSites = dataManipulationHistoricalSite.getDataHistoricalSites(ConfigResourceData.RESERVE_DATA_WIKIPEDIA_PATH);
        historicEvents = dataManipulationHistoricEvent.getDataHistoricEvents(ConfigResourceData.RESERVE_DATA_WIKIPEDIA_PATH);

        List<CulturalFestival> culturalFestivalList = dataManipulationCulturalFestival.getDataCulturalFestivals(ConfigResourceData.RESERVE_DATA_NGUOIKESU_PATH);
        List<HistoricalDynasty> historicalDynastyList = dataManipulationHistoricalDynasty.getDataHistoricalDynasties(ConfigResourceData.RESERVE_DATA_NGUOIKESU_PATH);
        List<HistoricalFigure> historicalFigureList = dataManipulationHistoricalFigure.getDataHistoricalFigures(ConfigResourceData.RESERVE_DATA_NGUOIKESU_PATH);
        List<HistoricalSite> historicalSiteList = dataManipulationHistoricalSite.getDataHistoricalSites(ConfigResourceData.RESERVE_DATA_NGUOIKESU_PATH);
        List<HistoricEvent> historicEventList = dataManipulationHistoricEvent.getDataHistoricEvents(ConfigResourceData.RESERVE_DATA_NGUOIKESU_PATH);

        for (CulturalFestival culturalFestival : culturalFestivalList) {
            culturalFestivals.add(culturalFestival);
        }

        for (HistoricalDynasty historicalDynasty : historicalDynastyList) {
            historicalDynasties.add(historicalDynasty);
        }

        for (HistoricalFigure historicalFigure : historicalFigureList) {
            historicalFigures.add(historicalFigure);
        }

        for (HistoricalSite historicalSite : historicalSiteList) {
            historicalSites.add(historicalSite);
        }

        for (HistoricEvent historicEvent : historicEventList) {
            historicEvents.add(historicEvent);
        }
    }
}
