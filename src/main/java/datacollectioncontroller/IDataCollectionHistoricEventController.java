package datacollectioncontroller;

import common.exception.HistoricEventDataCollectionException;
import entity.HistoricEvent;

import java.io.IOException;
import java.util.List;

public interface IDataCollectionHistoricEventController {

    public List<HistoricEvent> collectionDataHistoricEvent() throws IOException, HistoricEventDataCollectionException;
}
