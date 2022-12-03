package controller.datacollectioncontroller.datacollectioncontrollerimpl;

import controller.datacollectioncontroller.IDataCollectionController;
import entity.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataCollectionWikipediaController implements IDataCollectionController {
    @Override
    public List<CulturalFestival> collectionDataCulturalFestival() {
        return null;
    }

    @Override
    public List<HistoricalDynasty> collectionDataHistoricalDynasty() throws IOException {
        Document doc = Jsoup.connect("https://vi.wikipedia.org/wiki/Vua_Vi%E1%BB%87t_Nam").get();
        List<HistoricalDynasty> list = new ArrayList<>();
        int index = 1;
        Element elementClass = doc.getElementsByClass("wikitable").get(6);
        Elements elementsTr = elementClass.select("tr");
        elementsTr = elementsTr.next();
        while (elementsTr.iterator().hasNext()) {
            Element elementTr = elementsTr.iterator().next();
            HistoricalDynasty historicalDynasty = new HistoricalDynasty(index);
            historicalDynasty.setTenTrieuDai(elementTr.select("td").get(0).text());
            int i = elementTr.select("td").get(3).text().indexOf("[");
            if(i == -1) {
                historicalDynasty.setKinhDo(elementTr.select("td").get(3).text());
            } else {
                historicalDynasty.setKinhDo(elementTr.select("td").get(3).text().substring(0,i));
            }
            list.add(historicalDynasty);
            index++;
            elementsTr = elementsTr.next();
        }
        return list;
    }

    @Override
    public List<HistoricalFigure> collectionDataHistoricalFigure() {
        return null;
    }

    @Override
    public List<HistoricalSite> collectionDataHistoricalSite() {
        return null;
    }

    @Override
    public List<HistoricEvent> collectionDataHistoricEvent() {
        return null;
    }
}
