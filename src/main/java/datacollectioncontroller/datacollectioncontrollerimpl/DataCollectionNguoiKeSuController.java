package datacollectioncontroller.datacollectioncontrollerimpl;

import datacollectioncontroller.IDataCollectionController;

import entity.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import utils.configs.ConfigHtml;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataCollectionNguoiKeSuController implements IDataCollectionController {
    public List<CulturalFestival> collectionDataCulturalFestival() {
        return null;
    }

    @Override
    public List<HistoricalDynasty> collectionDataHistoricalDynasty() throws IOException {
        List<HistoricalDynasty> historicalDynasties = new ArrayList<>();
        int index = 1;
        String url = ConfigHtml.NGUOIKESU_URL + "/dong-lich-su";
        Document document = getDocument(url);
        Element elementId = document.getElementById("hs-timeline-97");
        Element elementUl = elementId.select("ul").get(1);
        Elements elementsLi = elementUl.select("li");
        while (elementsLi.iterator().hasNext()) {
            Element elementLi = elementsLi.iterator().next();
            String tenTrieuDai = elementLi.select("div").first().select("h3").first().text();
            tenTrieuDai = tenTrieuDai.replace("&nbsp;", "");
            String moTa = null;
            Element elementdiv = elementLi.select("div").first();
            Elements elementsP = elementdiv.select("p");
            while (elementsP.iterator().hasNext()) {
                Element elementP = elementsP.iterator().next();
                moTa += elementP.text();
                elementsP = elementsP.next();
            }
            System.out.println(tenTrieuDai);
            System.out.println(moTa);
            System.out.println("****************");
            elementsLi = elementsLi.next();
        }
        return historicalDynasties;
    }

    @Override
    public List<HistoricalFigure> collectionDataHistoricalFigure() throws IOException {
        List<HistoricalFigure> historicalFigures = new ArrayList<>();
        int index = 1;
        int startWeb = 0;
        while (startWeb < 1450) {
            String url = ConfigHtml.NGUOIKESU_URL + "/nhan-vat";
            if (startWeb != 0) {
                url += "?start=" + String.valueOf(startWeb);
            }
            Document document = getDocument(url);
            Element elementId = document.getElementById("jm-maincontent");
            Element elementDiv = elementId.select("div").first();
            Elements elementsdiv = elementDiv.select("div");
            while (elementsdiv.iterator().hasNext()) {
                try {
                    Element elementdiv = elementsdiv.iterator().next();
                    Element elementdiv1 = elementdiv.select("div").first();
                    Element elementdiv2 = elementdiv1.select("div").first();
                    String tenNhanVat = elementdiv2.select("div").first().select("h2").first().text();
                    String moTa = null;
                    Elements elementsP = elementdiv2.select("p");
                    while (elementsP.iterator().hasNext()) {
                        Element elementP = elementsP.iterator().next();
                        moTa += elementP.text();
                        elementsP = elementsP.next();
                    }
                    if (moTa.contains("Việt Nam")) {
                        System.out.println(tenNhanVat);
                        System.out.println(moTa);
                        System.out.println("****************");
                    }
                } catch (Exception e) {

                }
                elementsdiv = elementsdiv.next();
            }
            startWeb += 5;
        }
        return historicalFigures;
    }

    @Override
    public List<HistoricalSite> collectionDataHistoricalSite() throws IOException {
        List<HistoricalSite> historicalSites = new ArrayList<>();
        int index = 1;
        int startWeb = 0;
        while (startWeb < 30) {
            String url = ConfigHtml.NGUOIKESU_URL + "/di-tich-lich-su";
            if (startWeb != 0) {
                url += "?start=" + String.valueOf(startWeb);
            }
            Document document = getDocument(url);
            Element elementId = document.getElementById("adminForm");
            Element elementUl = elementId.select("ul").first();
            Elements elementsLi = elementUl.select("li");
            while (elementsLi.iterator().hasNext()) {
                Element elementLi = elementsLi.iterator().next();
                String tenDiTich = elementLi.select("h3").first().text();
                System.out.println(elementLi.select("h3").first().select("a").first().attr("href"));
                String moTa = null;
                Element elementSpan = elementLi.select("span").first();
                Elements elementsP = elementSpan.select("p");
                while (elementsP.iterator().hasNext()) {
                    Element elementP = elementsP.iterator().next();
                    moTa += elementP.text();
                    elementsP = elementsP.next();
                }
                if (moTa.contains("Việt Nam")) {
                    System.out.println(tenDiTich);
                    System.out.println(moTa);
                    System.out.println("****************");
                }
                elementsLi = elementsLi.next();
            }
            startWeb += 10;
        }
        return historicalSites;
    }

    @Override
    public List<HistoricEvent> collectionDataHistoricEvent() throws IOException {
        return null;
    }

    @Override
    public Document getDocument(String url) throws IOException {
        return IDataCollectionController.super.getDocument(url);
    }
}
