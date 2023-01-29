package datacollectioncontroller;

import common.exception.HistoricalFigureDataCollectionException;
import entity.HistoricalFigure;

import java.io.IOException;
import java.util.List;

public interface IDataCollectionHistoricalFigureController {

    /**
     * Thu thập dữ liệu về các nhân vật lịch sử Việt Nam
     * @return Danh sách các nhân vât lịch sử Việt Nam
     * @throws IOException
     * @throws HistoricalFigureDataCollectionException
     */
    public List<HistoricalFigure> collectionDataHistoricalFigure() throws IOException, HistoricalFigureDataCollectionException;
}
