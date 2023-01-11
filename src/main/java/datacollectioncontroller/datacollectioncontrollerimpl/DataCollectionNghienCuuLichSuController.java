package datacollectioncontroller.datacollectioncontrollerimpl;

import datacollectioncontroller.IDataCollectionController;
import entity.*;

import java.io.IOException;
import java.util.List;

public class DataCollectionNghienCuuLichSuController implements IDataCollectionController {
    @Override
    public List<CulturalFestival> collectionDataCulturalFestival() {
        return null;
    }

    @Override
    public List<HistoricalDynasty> collectionDataHistoricalDynasty() throws IOException {
        return null;
    }

    @Override
    public List<HistoricalFigure> collectionDataHistoricalFigure() {
        return null;
    }

    @Override
    public List<HistoricalSite> collectionDataHistoricalSite() {
        return null;
    }

    @Override
    public List<HistoricEvent> collectionDataHistoricEvent() {
        return null;
    }
}
