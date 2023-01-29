package datacollectioncontroller;

import common.exception.HistoricEventDataCollectionException;
import entity.HistoricEvent;

import java.io.IOException;
import java.util.List;

public interface IDataCollectionHistoricEventController {

    /**
     * Thu thập dữ liệu về các sự kiện lịch sử Việt Nam
     * @return Danh sách các sự kiện lịch sử Việt Nam
     * @throws IOException
     * @throws HistoricEventDataCollectionException
     */
    public List<HistoricEvent> collectionDataHistoricEvent() throws IOException, HistoricEventDataCollectionException;
}
