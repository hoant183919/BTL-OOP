package dataprocessingcontroller;

import data.datamanipulation.*;
import data.datamanipulation.datamanipulation.*;
import entity.*;
import utils.configs.ConfigHtml;
import utils.configs.ConfigResource;

import java.util.ArrayList;
import java.util.List;

public class BaseController {

    private String[] listUrl = {
            ConfigResource.RESERVE_DATA_NGHIENCUULICHSU_PATH,
            ConfigResource.RESERVE_DATA_NGUOIKESU_PATH,
            ConfigResource.RESERVE_DATA_WIKIPEDIA_PATH,
    };

    public List<CulturalFestival> getAllCulturalFestival() {
        List<CulturalFestival> culturalFestivals = new ArrayList<>();

        for (int i = 0; i < listUrl.length; i++) {
            IDataManipulationCulturalFestival dataManipulationCulturalFestival = new DataManipulationCulturalFestival();
            List<CulturalFestival> list = dataManipulationCulturalFestival.getDataCulturalFestivals(listUrl[i]);
            for (CulturalFestival culturalFestival : list) culturalFestivals.add(culturalFestival);
        }

        return culturalFestivals;
    }

    public List<HistoricalDynasty> getAllHistoricalDynasty() {
        List<HistoricalDynasty> historicalDynastys = new ArrayList<>();

        for (int i = 0; i < listUrl.length; i++) {
            IDataManipulationHistoricalDynasty dataManipulationHistoricalDynasty = new DataManipulationHistoricalDynasty();
            List<HistoricalDynasty> list = dataManipulationHistoricalDynasty.getDataHistoricalDynasties(listUrl[i]);
            for (HistoricalDynasty historicalDynasty : list) historicalDynastys.add(historicalDynasty);
        }

        return historicalDynastys;
    }

    public List<HistoricalFigure> getAllHistoricalFigure(){
        List<HistoricalFigure> historicalFigures = new ArrayList<>();

        for (int i = 0; i < listUrl.length; i++) {
            IDataManipulationHistoricalFigure dataManipulationHistoricalFigure = new DataManipulationHistoricalFigure();
            List<HistoricalFigure> list = dataManipulationHistoricalFigure.getDataHistoricalFigures(listUrl[i]);
            for (HistoricalFigure historicalFigure: list) historicalFigures.add(historicalFigure);
        }

        return historicalFigures;
    }

    public List<HistoricalSite> getAllHistoricalSite(){
        List<HistoricalSite> historicalSites = new ArrayList<>();

        for (int i = 0; i < listUrl.length; i++) {
            IDataManipulationHistoricalSite dataManipulationHistoricalSite = new DataManipulationHistoricalSite();
            List<HistoricalSite> list = dataManipulationHistoricalSite.getDataHistoricalSites(listUrl[i]);
            for (HistoricalSite historicalSite : list) historicalSites.add(historicalSite);
        }

        return historicalSites;
    }

    public List<HistoricEvent> getAllHistoricEvent(){
        List<HistoricEvent> historicEvents = new ArrayList<>();

        for (int i = 0; i < listUrl.length; i++) {
            IDataManipulationHistoricEvent dataManipulationHistoricEvent = new DataManipulationHistoricEvent();
            List<HistoricEvent> list = dataManipulationHistoricEvent.getDataHistoricEvents(listUrl[i]);
            for (HistoricEvent historicEvent : list) historicEvents.add(historicEvent);
        }

        return historicEvents;
    }
}