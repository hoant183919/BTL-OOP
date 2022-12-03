package main.java.controller.datacollectioncontroller;

import main.java.entity.*;

import java.util.List;

public interface IDataCollectionController {
    public List<CulturalFestival> collectionDataCulturalFestival();
    public List<HistoricalDynasty> collectionDataHistoricalDynasty();
    public List<HistoricalFigure> collectionDataHistoricalFigure();
    public List<HistoricalSite> collectionDataHistoricalSite();
    public List<HistoricEvent> collectionDataHistoricEvent();
}
