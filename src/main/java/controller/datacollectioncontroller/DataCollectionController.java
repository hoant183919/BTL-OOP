package controller.datacollectioncontroller;

import controller.datacollectioncontroller.datacollectioncontrollerimpl.DataCollectionNghienCuuLichSuController;
import controller.datacollectioncontroller.datacollectioncontrollerimpl.DataCollectionNguoiKeSuController;
import controller.datacollectioncontroller.datacollectioncontrollerimpl.DataCollectionWikipediaController;
import data.datamanipulation.*;
import data.datamanipulation.datamanipulation.*;
import entity.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static utils.configs.ConfigResource.*;

public class DataCollectionController {
    public void collectData() throws IOException {
        HashMap<String, IDataCollectionController> dataCollectionControllers = new HashMap<>();
        dataCollectionControllers.put(RESERVE_DATA_NGUOIKESU_PATH, new DataCollectionNguoiKeSuController());
        dataCollectionControllers.put(RESERVE_DATA_WIKIPEDIA_PATH, new DataCollectionWikipediaController());
        dataCollectionControllers.put(RESERVE_DATA_NGHIENCUULICHSU_PATH, new DataCollectionNghienCuuLichSuController());
        for (Map.Entry<String, IDataCollectionController> entry : dataCollectionControllers.entrySet()) {
            if (entry.getValue() != null) {
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
            }
        }
    }
}
