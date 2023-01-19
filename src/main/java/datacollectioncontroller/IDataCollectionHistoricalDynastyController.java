package datacollectioncontroller;

import entity.HistoricalDynasty;

import java.io.IOException;
import java.util.List;

public interface IDataCollectionHistoricalDynastyController {

    public List<HistoricalDynasty> collectionDataHistoricalDynasty() throws IOException;
}
