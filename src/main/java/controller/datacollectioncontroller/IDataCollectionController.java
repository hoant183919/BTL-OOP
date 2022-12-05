package controller.datacollectioncontroller;

import entity.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import utils.configs.SSLHelper;

import java.io.IOException;
import java.util.List;

import static javafx.css.StyleOrigin.USER_AGENT;

public interface IDataCollectionController {
    public List<CulturalFestival> collectionDataCulturalFestival() throws IOException;
    public List<HistoricalDynasty> collectionDataHistoricalDynasty() throws IOException;
    public List<HistoricalFigure> collectionDataHistoricalFigure() throws IOException;
    public List<HistoricalSite> collectionDataHistoricalSite() throws IOException;
    public List<HistoricEvent> collectionDataHistoricEvent() throws IOException;

    public default Document getDocument(String url) throws IOException {
        return SSLHelper.getConnection(url).userAgent(String.valueOf(USER_AGENT)).get();
    }
}
