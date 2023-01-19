package datacollectioncontroller;

import entity.HistoricalFigure;

import java.io.IOException;
import java.util.List;

public interface IDataCollectionHistoricalFigureController {

    public List<HistoricalFigure> collectionDataHistoricalFigure() throws IOException;
}
