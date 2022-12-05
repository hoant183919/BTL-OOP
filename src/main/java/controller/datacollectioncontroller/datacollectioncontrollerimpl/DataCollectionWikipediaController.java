package controller.datacollectioncontroller.datacollectioncontrollerimpl;

import controller.datacollectioncontroller.IDataCollectionController;
import entity.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import utils.configs.ConfigHtml;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataCollectionWikipediaController implements IDataCollectionController {
    @Override
    public List<CulturalFestival> collectionDataCulturalFestival() throws IOException {
        List<CulturalFestival> culturalFestivals = new ArrayList<>();
        Document document = getDocument(ConfigHtml.WIKIPEDIA_URL);
        return culturalFestivals;
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
            if (i == -1) {
                historicalDynasty.setKinhDo(elementTr.select("td").get(3).text());
            } else {
                historicalDynasty.setKinhDo(elementTr.select("td").get(3).text().substring(0, i));
            }
            list.add(historicalDynasty);
            index++;
            elementsTr = elementsTr.next();
        }
        return list;
    }

    @Override
    public List<HistoricalFigure> collectionDataHistoricalFigure() throws IOException {
        List<HistoricalFigure> historicalFigures = new ArrayList<>();
        Document document = getDocument(ConfigHtml.WIKIPEDIA_URL);

        return historicalFigures;
    }

    @Override
    public List<HistoricalSite> collectionDataHistoricalSite() throws IOException {
        List<HistoricalSite> historicalSites = new ArrayList<>();
        int index = 1;
        Document document = getDocument(ConfigHtml.WIKIPEDIA_URL + "wiki/Danh_sách_Di_tích_quốc_gia_Việt_Nam");
        System.out.println(document.title());
        Elements elementsH3 = document.select("h3");
        Elements elementsTable = document.select("table").attr("class", "wikitable sortable jquery-tablesorter");
        while (elementsH3.iterator().hasNext() && elementsTable.iterator().hasNext()) {
            Element elementH3 = elementsH3.iterator().next();
            if(!elementH3.select("span").iterator().hasNext()){
                elementsH3 = elementsH3.next();
                continue;
            }
            Element elementTable = elementsTable.iterator().next();
            System.out.println(elementH3.select("span").get(1).text());
//            if(!elementTable.attr("class").equals("wikitable sortable jquery-tablesorter")){
//                break;
//            }
//            Element elementTbody = elementTable.select("tbody").first();
//            Elements elementsTr = elementTbody.select("tr");
//            while (elementsTr.iterator().hasNext()) {
//                Element elementTr = elementsTr.iterator().next();
////                System.out.println(elementTr.text());
//                for (int i = 0; i < 5; i++) {
//
//                }
//                elementsTr = elementsTr.next();
//            }
            index++;
            elementsH3 = elementsH3.next();
        }
        System.out.println(index);
        return historicalSites;
    }

    @Override
    public List<HistoricEvent> collectionDataHistoricEvent() throws IOException {
        List<HistoricEvent> historicEvents = new ArrayList<>();
        Document document = getDocument(ConfigHtml.WIKIPEDIA_URL);

        return historicEvents;
    }
}
