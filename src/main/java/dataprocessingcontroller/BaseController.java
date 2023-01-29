package dataprocessingcontroller;

import entity.*;

import java.util.ArrayList;
import java.util.List;

public class BaseController {

//    private String[] listUrl = {
//            ConfigResource.RESERVE_DATA_NGHIENCUULICHSU_PATH,
//            ConfigResource.RESERVE_DATA_NGUOIKESU_PATH,
//            ConfigResource.RESERVE_DATA_WIKIPEDIA_PATH,
//    };

    public List<CulturalFestival> getAllCulturalFestival() {
//        List<CulturalFestival> culturalFestivals = new ArrayList<>();
//
////        for (int i = 0; i < listUrl.length; i++) {
////            IDataManipulationCulturalFestival dataManipulationCulturalFestival = new DataManipulationCulturalFestival();
////            List<CulturalFestival> list = dataManipulationCulturalFestival.getDataCulturalFestivals(listUrl[i]);
////            for (CulturalFestival culturalFestival : list) culturalFestivals.add(culturalFestival);
////        }
//        List<CulturalFestival> list = new ArrayList<>();
//
//        list = DataWikipediaSingleton.getInstance().getCulturalFestivals();
//        for (CulturalFestival culturalFestival : list) culturalFestivals.add(culturalFestival);
//
//        list = DataNguoiKeSuSingleton.getInstance().getCulturalFestivals();
//        for (CulturalFestival culturalFestival : list) culturalFestivals.add(culturalFestival);
//
//        return culturalFestivals;
        return DataSingleton.getInstance().getCulturalFestivals();
    }

    public List<HistoricalDynasty> getAllHistoricalDynasty() {
//        List<HistoricalDynasty> historicalDynastys = new ArrayList<>();
//
////        for (int i = 0; i < listUrl.length; i++) {
////            IDataManipulationHistoricalDynasty dataManipulationHistoricalDynasty = new DataManipulationHistoricalDynasty();
////            List<HistoricalDynasty> list = dataManipulationHistoricalDynasty.getDataHistoricalDynasties(listUrl[i]);
////            for (HistoricalDynasty historicalDynasty : list) historicalDynastys.add(historicalDynasty);
////        }
//        List<HistoricalDynasty> list = new ArrayList<>();
//
//        list = DataWikipediaSingleton.getInstance().getHistoricalDynasties();
//        for (HistoricalDynasty historicalDynasty : list) historicalDynastys.add(historicalDynasty);
//
//        list = DataNguoiKeSuSingleton.getInstance().getHistoricalDynasties();
//        for (HistoricalDynasty historicalDynasty : list) historicalDynastys.add(historicalDynasty);
//
//        return historicalDynastys;
        return DataSingleton.getInstance().getHistoricalDynasties();
    }

    public List<HistoricalFigure> getAllHistoricalFigure() {
//        List<HistoricalFigure> historicalFigures = new ArrayList<>();
//
////        for (int i = 0; i < listUrl.length; i++) {
////            IDataManipulationHistoricalFigure dataManipulationHistoricalFigure = new DataManipulationHistoricalFigure();
////            List<HistoricalFigure> list = dataManipulationHistoricalFigure.getDataHistoricalFigures(listUrl[i]);
////            for (HistoricalFigure historicalFigure : list) historicalFigures.add(historicalFigure);
////        }
//        List<HistoricalFigure> list = new ArrayList<>();
//
//        list = DataWikipediaSingleton.getInstance().getHistoricalFigures();
//        for (HistoricalFigure historicalFigure : list) historicalFigures.add(historicalFigure);
//
//        list = DataNguoiKeSuSingleton.getInstance().getHistoricalFigures();
//        for (HistoricalFigure historicalFigure : list) historicalFigures.add(historicalFigure);
//
//        return historicalFigures;
        return DataSingleton.getInstance().getHistoricalFigures();
    }

    public List<HistoricalSite> getAllHistoricalSite() {
//        List<HistoricalSite> historicalSites = new ArrayList<>();
//
////        for (int i = 0; i < listUrl.length; i++) {
////            IDataManipulationHistoricalSite dataManipulationHistoricalSite = new DataManipulationHistoricalSite();
////            List<HistoricalSite> list = dataManipulationHistoricalSite.getDataHistoricalSites(listUrl[i]);
////            for (HistoricalSite historicalSite : list) historicalSites.add(historicalSite);
////        }
//        List<HistoricalSite> list = new ArrayList<>();
//
//        list = DataWikipediaSingleton.getInstance().getHistoricalSites();
//        for (HistoricalSite historicalSite : list) historicalSites.add(historicalSite);
//
//        list = DataNguoiKeSuSingleton.getInstance().getHistoricalSites();
//        for (HistoricalSite historicalSite : list) historicalSites.add(historicalSite);
//
//        return historicalSites;
        return DataSingleton.getInstance().getHistoricalSites();
    }

    public List<HistoricEvent> getAllHistoricEvent() {
//        List<HistoricEvent> historicEvents = new ArrayList<>();
//
////        for (int i = 0; i < listUrl.length; i++) {
////            IDataManipulationHistoricEvent dataManipulationHistoricEvent = new DataManipulationHistoricEvent();
////            List<HistoricEvent> list = dataManipulationHistoricEvent.getDataHistoricEvents(listUrl[i]);
////            for (HistoricEvent historicEvent : list) historicEvents.add(historicEvent);
////        }
//        List<HistoricEvent> list = new ArrayList<>();
//
//        list = DataWikipediaSingleton.getInstance().getHistoricEvents();
//        for (HistoricEvent historicEvent : list) historicEvents.add(historicEvent);
//
//        list = DataNguoiKeSuSingleton.getInstance().getHistoricEvents();
//        for (HistoricEvent historicEvent : list) historicEvents.add(historicEvent);
//
//        return historicEvents;
        return DataSingleton.getInstance().getHistoricEvents();
    }
}
