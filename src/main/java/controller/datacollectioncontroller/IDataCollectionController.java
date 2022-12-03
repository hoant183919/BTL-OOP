package controller.datacollectioncontroller;

import entity.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import utils.configs.SSLHelper;

import java.io.IOException;
import java.util.List;

import static javafx.css.StyleOrigin.USER_AGENT;

public interface IDataCollectionController {
    public List<CulturalFestival> collectionDataCulturalFestival();
    public List<HistoricalDynasty> collectionDataHistoricalDynasty() throws IOException;
    public List<HistoricalFigure> collectionDataHistoricalFigure();
    public List<HistoricalSite> collectionDataHistoricalSite();
    public List<HistoricEvent> collectionDataHistoricEvent();

    public default Document getDocument(String url) throws IOException {
        return SSLHelper.getConnection(url).userAgent(String.valueOf(USER_AGENT)).get();
    }
}
