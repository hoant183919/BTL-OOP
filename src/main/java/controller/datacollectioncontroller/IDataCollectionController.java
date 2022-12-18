package controller.datacollectioncontroller;

import entity.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import utils.configs.SSLHelper;

import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

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

    public default String getDescription(String url) throws IOException {
        StringBuffer stringBuffer = new StringBuffer("");
        Document documentDescription = getDocument(url);
        Element elementId = documentDescription.getElementById("mw-content-text");
        Element elementClass = elementId.getElementsByClass("mw-parser-output").first();
        Elements elementsP = elementClass.select("p");
        while (elementsP.iterator().hasNext()) {
            Element elementP = elementsP.iterator().next();
            Elements elementsSpanDescription = elementP.select("span");
            if (!elementsSpanDescription.iterator().hasNext()) {
                stringBuffer.append(elementP.text());
            }
            elementsP = elementsP.next();
        }
        return stringBuffer.toString();
    }

    public default List<String> getSentenceHasInfo(StringTokenizer stringTokenizer, String info) {
        List<String> infos = null;
        while (stringTokenizer.hasMoreTokens()) {
            String str = stringTokenizer.nextToken();
            if (str.contains(info)) {
                infos.add(str);
            }
        }
        return infos;
    }
}
