package datacollectioncontroller;

import datacollectioncontroller.datacollectioncontrollerimpl.DataCollectionNghienCuuLichSuController;
import datacollectioncontroller.datacollectioncontrollerimpl.DataCollectionNguoiKeSuController;
import datacollectioncontroller.datacollectioncontrollerimpl.DataCollectionWikipediaController;
import data.datamanipulation.*;
import data.datamanipulation.datamanipulation.*;
import entity.*;
import utils.Utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import static utils.configs.ConfigResource.*;

public class DataCollectionController {
    public void collectData() throws IOException {
        HashMap<String, IDataCollectionController> dataCollectionControllers = new HashMap<>();
        dataCollectionControllers.put(RESERVE_DATA_NGUOIKESU_PATH, new DataCollectionNguoiKeSuController());
        dataCollectionControllers.put(RESERVE_DATA_WIKIPEDIA_PATH, new DataCollectionWikipediaController());
        dataCollectionControllers.put(RESERVE_DATA_NGHIENCUULICHSU_PATH, new DataCollectionNghienCuuLichSuController());
        for (Map.Entry<String, IDataCollectionController> entry : dataCollectionControllers.entrySet()) {
            if (entry.getValue() != null) {
                try {
                    List<CulturalFestival> culturalFestivals = entry.getValue().collectionDataCulturalFestival();
                    if (culturalFestivals != null) {
                        IDataManipulationCulturalFestival dataManipulationCulturalFestival = new DataManipulationCulturalFestival();
                        dataManipulationCulturalFestival.insertDataCulturalFestivals(entry.getKey() + NAME_FILE[0], culturalFestivals);
                    }
                    List<HistoricalDynasty> historicalDynasties = entry.getValue().collectionDataHistoricalDynasty();
                    if (historicalDynasties != null) {
                        IDataManipulationHistoricalDynasty dataManipulationHistoricalDynasty = new DataManipulationHistoricalDynasty();
                        dataManipulationHistoricalDynasty.insertDataHistoricalDynasties(entry.getKey() + NAME_FILE[1], historicalDynasties);
                    }
                    List<HistoricalFigure> historicalFigures = entry.getValue().collectionDataHistoricalFigure();
                    if (historicalFigures != null) {
                        IDataManipulationHistoricalFigure dataManipulationHistoricalFigure = new DataManipulationHistoricalFigure();
                        dataManipulationHistoricalFigure.insertDataHistoricalFigures(entry.getKey() + NAME_FILE[2], historicalFigures);
                    }
                    List<HistoricalSite> historicalSites = entry.getValue().collectionDataHistoricalSite();
                    if (historicalSites != null) {
                        IDataManipulationHistoricalSite dataManipulationHistoricalSite = new DataManipulationHistoricalSite();
                        dataManipulationHistoricalSite.insertDataHistoricalSites(entry.getKey() + NAME_FILE[3], historicalSites);
                    }
                    List<HistoricEvent> historicEvents = entry.getValue().collectionDataHistoricEvent();
                    if (historicEvents != null) {
                        IDataManipulationHistoricEvent dataManipulationHistoricEvent = new DataManipulationHistoricEvent();
                        dataManipulationHistoricEvent.insertDataHistoricEvents(entry.getKey() + NAME_FILE[4], historicEvents);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void collectData(String url, IDataCollectionController dataCollectionController) throws IOException {
        try {
            List<CulturalFestival> culturalFestivals = dataCollectionController.collectionDataCulturalFestival();
            if (culturalFestivals != null) {
                IDataManipulationCulturalFestival dataManipulationCulturalFestival = new DataManipulationCulturalFestival();
                dataManipulationCulturalFestival.insertDataCulturalFestivals(url + NAME_FILE[0], culturalFestivals);
            }
            List<HistoricalDynasty> historicalDynasties = dataCollectionController.collectionDataHistoricalDynasty();
            if (historicalDynasties != null) {
                IDataManipulationHistoricalDynasty dataManipulationHistoricalDynasty = new DataManipulationHistoricalDynasty();
                dataManipulationHistoricalDynasty.insertDataHistoricalDynasties(url + NAME_FILE[1], historicalDynasties);
            }
            List<HistoricalFigure> historicalFigures = dataCollectionController.collectionDataHistoricalFigure();
            if (historicalFigures != null) {
                IDataManipulationHistoricalFigure dataManipulationHistoricalFigure = new DataManipulationHistoricalFigure();
                dataManipulationHistoricalFigure.insertDataHistoricalFigures(url + NAME_FILE[2], historicalFigures);
            }
            List<HistoricalSite> historicalSites = dataCollectionController.collectionDataHistoricalSite();
            if (historicalSites != null) {
                IDataManipulationHistoricalSite dataManipulationHistoricalSite = new DataManipulationHistoricalSite();
                dataManipulationHistoricalSite.insertDataHistoricalSites(url + NAME_FILE[3], historicalSites);
            }
            List<HistoricEvent> historicEvents = dataCollectionController.collectionDataHistoricEvent();
            if (historicEvents != null) {
                IDataManipulationHistoricEvent dataManipulationHistoricEvent = new DataManipulationHistoricEvent();
                dataManipulationHistoricEvent.insertDataHistoricEvents(url + NAME_FILE[4], historicEvents);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getRelationship(List<List<BaseEntity>> lists) {
        for (int i = 0; i < lists.size(); i++) {
            List<BaseEntity> baseEntities = lists.get(i);
            int k = 0;
            while (k < baseEntities.size()) {
                BaseEntity baseEntity = baseEntities.get(k);
                System.out.println(baseEntity.getTen() + " --- ");
                for (int j = 0; j < lists.size(); j++) {
                    List<BaseEntity> baseEntitiesSearch = lists.get(j);
                    if (baseEntity.getMoTa() != null) {
                        int l = 0;
                        while (l < baseEntitiesSearch.size()) {
                            BaseEntity baseEntitySearch = baseEntitiesSearch.get(l);
                            if (!baseEntity.getTen().equals(baseEntitySearch.getTen())) {
                                if (Utils.removeSign4VietnameseString(baseEntity.getMoTa()).toLowerCase().contains(Utils.removeSign4VietnameseString(baseEntitySearch.getTen()).toLowerCase())) {
                                    StringTokenizer stringTokenizer = new StringTokenizer(baseEntity.getMoTa(), ".");
                                    List<String> infos = Utils.getSentenceHasInfo(stringTokenizer, baseEntitySearch.getTen());
                                    if (infos.size() != 0) {
                                        System.out.print(baseEntitySearch.getTen() + " - ");
                                        int p = 0;
                                        while (p < infos.size()) {
                                            if (infos.get(p) != null && !infos.get(p).equals(""))
                                                System.out.print(infos.get(p) + "  ");
                                            p++;
                                        }
                                    }
                                    System.out.println();
                                }
                            }
                            l++;
                        }
                    }
                }
                System.out.println();
                System.out.println("***********************");
                System.out.println();
                k++;
            }
        }
    }
}
