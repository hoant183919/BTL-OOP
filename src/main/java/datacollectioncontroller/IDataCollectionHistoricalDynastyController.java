package datacollectioncontroller;

import common.exception.HistoricalDynastyDataCollectionException;
import entity.HistoricalDynasty;

import java.io.IOException;
import java.util.List;

public interface IDataCollectionHistoricalDynastyController {

    /**
     * Thu thập dữ liệu về các triều đại lịch sử Việt Nam
     * @return Danh sách các triều đại lịch sử Việt Nam
     * @throws IOException
     * @throws HistoricalDynastyDataCollectionException
     */
    public List<HistoricalDynasty> collectionDataHistoricalDynasty() throws IOException, HistoricalDynastyDataCollectionException;
}
