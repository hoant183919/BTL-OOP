package controller.datacollectioncontroller;

import controller.datacollectioncontroller.datacollectioncontrollerimpl.DataCollectionNghienCuuLichSuController;
import controller.datacollectioncontroller.datacollectioncontrollerimpl.DataCollectionNguoiKeSuController;
import controller.datacollectioncontroller.datacollectioncontrollerimpl.DataCollectionWikipediaController;
import data.datamanipulation.*;
import data.datamanipulation.datamanipulation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static utils.configs.ConfigResource.*;

public class DataCollectionController {
    public void collectData() throws IOException {
        HashMap<String, IDataCollectionController> dataCollectionControllers = new HashMap<>();
        dataCollectionControllers.put(RESERVE_DATA_NGUOIKESU_PATH, new DataCollectionNguoiKeSuController());
        dataCollectionControllers.put(RESERVE_DATA_WIKIPEDIA_PATH, new DataCollectionWikipediaController());
        dataCollectionControllers.put(RESERVE_DATA_NGHIENCUULICHSU_PATH, new DataCollectionNghienCuuLichSuController());
        for (Map.Entry<String, IDataCollectionController> entry : dataCollectionControllers.entrySet()) {
            if(entry.getValue()!=null) {
                if(entry.getValue().collectionDataCulturalFestival()!=null) {
                    IDataManipulationCulturalFestival dataManipulationCulturalFestival = new DataManipulationCulturalFestival();
                    dataManipulationCulturalFestival.insertDataCulturalFestivals(entry.getKey() + NAME_FILE[0], entry.getValue().collectionDataCulturalFestival());
                }
                if(entry.getValue().collectionDataHistoricalDynasty()!=null) {
                    IDataManipulationHistoricalDynasty dataManipulationHistoricalDynasty = new DataManipulationHistoricalDynasty();
                    dataManipulationHistoricalDynasty.insertDataHistoricalDynasties(entry.getKey() + NAME_FILE[1], entry.getValue().collectionDataHistoricalDynasty());
                }
                if(entry.getValue().collectionDataHistoricalFigure()!=null) {
                    IDataManipulationHistoricalFigure dataManipulationHistoricalFigure = new DataManipulationHistoricalFigure();
                    dataManipulationHistoricalFigure.insertDataHistoricalFigures(entry.getKey() + NAME_FILE[2], entry.getValue().collectionDataHistoricalFigure());
                }
                if(entry.getValue().collectionDataHistoricalSite()!=null) {
                    IDataManipulationHistoricalSite dataManipulationHistoricalSite = new DataManipulationHistoricalSite();
                    dataManipulationHistoricalSite.insertDataHistoricalSites(entry.getKey() + NAME_FILE[3], entry.getValue().collectionDataHistoricalSite());
                }
                if(entry.getValue().collectionDataHistoricEvent()!=null) {
                    IDataManipulationHistoricEvent dataManipulationHistoricEvent = new DataManipulationHistoricEvent();
                    dataManipulationHistoricEvent.insertDataHistoricEvents(entry.getKey() + NAME_FILE[4], entry.getValue().collectionDataHistoricEvent());
                }
            }
        }
    }
}
