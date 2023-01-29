package datacollectioncontroller;

import common.exception.HistoricalSiteDataCollectionException;
import entity.HistoricalSite;

import java.io.IOException;
import java.util.List;

public interface IDataCollectionHistoricalSiteController {

    public List<HistoricalSite> collectionDataHistoricalSite() throws IOException, HistoricalSiteDataCollectionException;
}
