package datacollectioncontroller;

import common.exception.CulturalFestivalDataCollectionException;
import common.exception.HistoricEventDataCollectionException;
import common.exception.HistoricalFigureDataCollectionException;
import entity.*;
import org.jsoup.nodes.Document;
import utils.configs.SSLHelper;

import java.io.IOException;
import java.util.*;

import static javafx.css.StyleOrigin.USER_AGENT;

public interface IDataCollectionController {
    public List<CulturalFestival> collectionDataCulturalFestival() throws IOException, CulturalFestivalDataCollectionException;

    public List<HistoricalDynasty> collectionDataHistoricalDynasty() throws IOException, HistoricEventDataCollectionException;

    public List<HistoricalFigure> collectionDataHistoricalFigure() throws IOException, HistoricalFigureDataCollectionException;

    public List<HistoricalSite> collectionDataHistoricalSite() throws IOException;

    public List<HistoricEvent> collectionDataHistoricEvent() throws IOException;

    public default Document getDocument(String url) throws IOException {
        return SSLHelper.getConnection(url).userAgent(String.valueOf(USER_AGENT)).get();
    }
}
