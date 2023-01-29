package datacollectioncontroller;

import common.exception.HistoricalSiteDataCollectionException;
import entity.HistoricalSite;

import java.io.IOException;
import java.util.List;

public interface IDataCollectionHistoricalSiteController {

    /**
     * Thu thập dữ liệu về các  di tích của Việt Nam
     * @return Danh sách các di tích của Việt Nam
     * @throws IOException
     * @throws HistoricalSiteDataCollectionException
     */
    public List<HistoricalSite> collectionDataHistoricalSite() throws IOException, HistoricalSiteDataCollectionException;
}
