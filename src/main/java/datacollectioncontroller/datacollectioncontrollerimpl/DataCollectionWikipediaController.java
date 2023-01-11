package datacollectioncontroller.datacollectioncontrollerimpl;

import datacollectioncontroller.IDataCollectionController;
import entity.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import utils.Utils;
import utils.configs.ConfigHtml;

import java.io.IOException;
import java.util.*;

public class DataCollectionWikipediaController implements IDataCollectionController {

    private static final String idSpanHaNoi = "Th.E1.BB.A7_.C4.91.C3.B4_H.C3.A0_N.E1.BB.99i";
    private static final String idSpanNinhBinh = "Ninh_B.C3.ACnh";
    private List<String> exceptionHistoricEvents;

    @Override
    public List<CulturalFestival> collectionDataCulturalFestival() throws IOException {
        List<CulturalFestival> culturalFestivals = new ArrayList<>();
        int index = 1;

        List<String> administrativeUnits = new ArrayList<>();
        administrativeUnits.add("xã");
        administrativeUnits.add("huyện");
        administrativeUnits.add("tỉnh");
        administrativeUnits.add("Thành phố");

        Document document = getDocument(ConfigHtml.WIKIPEDIA_URL + "/wiki/Lễ_hội_Việt_Nam");
        Element eId = document.getElementById("mw-content-text");
        Elements esDl = eId.select("dl");

        Element eTable = eId.select("table").get(1);
        Map<Integer, List<String>> listMap = new HashMap<>();
        listMap = getDataTable(eTable, 5, 3);

        for (int i = 0; i < listMap.size(); i++) {
            List<String> list = listMap.get(i);
            System.out.println(list);
            CulturalFestival culturalFestival = new CulturalFestival(index);
            try {
                culturalFestival.setTen(Utils.removeComments(list.get(2)));
                culturalFestival.setKieu("cultural-festival");
                culturalFestival.setThoiGian(Utils.removeComments(list.get(0)));
                culturalFestival.setDiaDiem(Utils.removeComments(list.get(1)));
                culturalFestival.setThoiDiemToChucLanDau(Utils.removeComments(list.get(3)));
                culturalFestival.setGhiChu(Utils.removeComments(list.get(4)));
                String linkCulturalFestival = list.get(5);
                if (linkCulturalFestival.contains("/wiki/")) {
                    culturalFestival.setMoTa(Utils.removeComments(getDescription(ConfigHtml.WIKIPEDIA_URL + linkCulturalFestival)));
                }
                culturalFestivals.add(culturalFestival);
                index++;
            } catch (IndexOutOfBoundsException e) {
                e.printStackTrace();
            }
        }
        return culturalFestivals;
    }

    @Override
    public List<HistoricalDynasty> collectionDataHistoricalDynasty() throws IOException {
        List<HistoricalDynasty> historicalDynasties = new ArrayList<>();
        int index = 1;

        Document document = getDocument(ConfigHtml.WIKIPEDIA_URL + "/wiki/Vua_Vi%E1%BB%87t_Nam");
        Element elementClass = document.getElementsByClass("wikitable").get(6);
        Elements elementsTr = elementClass.select("tr");
        elementsTr = elementsTr.next();
        while (elementsTr.iterator().hasNext()) {
            Element elementTr = elementsTr.iterator().next();
            Elements elementsTd = elementTr.select("td");
            HistoricalDynasty historicalDynasty = new HistoricalDynasty(index);

            try {
                historicalDynasty.setTen(elementsTd.first().text());
                System.out.println(elementsTd.first().text());
                String linkHistoricalDynasty = elementsTd.first().select("a").first().attr("href");
                if (linkHistoricalDynasty.contains("/wiki/")) {
                    String moTa = Utils.removeComments(getDescription(ConfigHtml.WIKIPEDIA_URL + linkHistoricalDynasty));
                    StringTokenizer stringTokenizer = new StringTokenizer(moTa, ".");
                    StringTokenizer listToken = stringTokenizer;
                    while (listToken.hasMoreTokens()) {
                        String token = listToken.nextToken();
                        if (token.contains("thành lập")) {
                            System.out.println(token);
                            break;
                        }
                    }
                    historicalDynasty.setMoTa(moTa);
                }
                int i = elementsTd.get(3).text().indexOf("[");
                if (i == -1) {
                    historicalDynasty.setKinhDo(elementsTd.get(3).text());
                } else {
                    historicalDynasty.setKinhDo(elementsTd.get(3).text().substring(0, i));
                }

                historicalDynasties.add(historicalDynasty);

                index++;
            } catch (IndexOutOfBoundsException e) {
                e.printStackTrace();
            }
            elementsTr = elementsTr.next();
        }
        return historicalDynasties;
    }

    @Override
    public List<HistoricalFigure> collectionDataHistoricalFigure() throws IOException {
        List<HistoricalFigure> historicalFigures = new ArrayList<>();
        int index = 1;

        Document document = getDocument(ConfigHtml.WIKIPEDIA_URL + "/wiki/Vua_Vi%E1%BB%87t_Nam");
        Elements elementsTable = document.select("table");
        elementsTable = elementsTable.next();

        while (elementsTable.iterator().hasNext()) {
            Element eTable = elementsTable.iterator().next();
            if (!(eTable.attr("style").equals("width:100%; font-size:90%; text-align:center; border:1px solid lavender;") || eTable.attr("style").equals("width:100%; font-size:90%; text-align:center; border:lavender;"))) {
                elementsTable = elementsTable.next();
                continue;
            }
            Element elementTbody = eTable.select("tbody").first();
            if (elementTbody == null) {
                elementsTable = elementsTable.next();
                continue;
            }
            Elements elementsTr = elementTbody.select("tr");
            if (elementsTr == null) {
                elementsTable = elementsTable.next();
                continue;
            }
            String typeDominator = Utils.removeComments(elementsTr.iterator().next().select("th").get(1).text());

            Map<Integer, List<String>> listMap = new HashMap<>();
            listMap = getDataTable(eTable, 8, 2);

            for (int i = 0; i < listMap.size(); i++) {
                List<String> list = listMap.get(i);
                Dominator dominator = new Dominator(index);

                try {
                    dominator.setTen(Utils.removeComments(list.get(1)));
                    dominator.setMieuHieu(Utils.removeComments(list.get(2)));
                    dominator.setThuyHieu(Utils.removeComments(list.get(3)));
                    dominator.setNienHieu(Utils.removeComments(list.get(4)));
                    dominator.setTenHuy(Utils.removeComments(list.get(5)));
                    dominator.setTheThu(Utils.removeComments(list.get(6)));
                    dominator.setTriVi(Utils.removeComments(list.get(7)));
                    dominator.setKieu("dominator");
                    dominator.setVaiTro(typeDominator);
                    try {
                        String linkDominator = list.get(8);
                        if (linkDominator.contains("/wiki/")) {
                            String description = Utils.removeComments(getDescription(ConfigHtml.WIKIPEDIA_URL + linkDominator));
                            StringTokenizer stringTokenizer = new StringTokenizer(description, ".");
                            String life = stringTokenizer.nextToken();
                            life = life.substring(life.indexOf("(") + 1, life.indexOf(")"));
                            life = life.replace("(", "");
                            life = life.replace(",", "");
                            life = life.replace(";", "");
                            if (life.contains("chữ Hán")) {
                                life = life.replace("chữ Hán:", "").trim();
                                StringBuffer kanjiName = new StringBuffer("");
                                int j = 0;
                                while (j < life.length()) {
                                    if (String.valueOf(life.charAt(j)).equals(" ")) {
                                        break;
                                    } else {
                                        kanjiName.append(life.charAt(j));
                                    }
                                    j++;
                                }
                                dominator.setTenChuHan(kanjiName.toString());
                                if (!life.substring(j + 1).contains("trị vì")) {
                                    dominator.setNamSinhMat(life.substring(j + 1));
                                }
                            }
                            dominator.setMoTa(description);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    historicalFigures.add(dominator);
                    index++;
                } catch (IndexOutOfBoundsException e) {
                    e.printStackTrace();
                }
            }

            elementsTable = elementsTable.next();
        }
        return historicalFigures;
    }

    @Override
    public List<HistoricalSite> collectionDataHistoricalSite() throws IOException {
        List<HistoricalSite> historicalSites = new ArrayList<>();
        int index = 1;
        Document document = getDocument(ConfigHtml.WIKIPEDIA_URL + "/wiki/Danh_sách_Di_tích_quốc_gia_Việt_Nam");
        System.out.println(document.title());
        Elements esH3 = document.select("h3");
        Elements esH2 = document.select("h2");

        int sizeElementsH2 = esH2.size();
        List<String> listIdH2 = new ArrayList<>();

        for (int i = 1; i < sizeElementsH2; i++) {
            Element eH2 = esH2.get(i);
            Elements esSpan = eH2.select("span");
            if (!esSpan.iterator().hasNext()) {
                esH2 = esH2.next();
                continue;
            }
            listIdH2.add(esSpan.first().id());
        }

        Elements elementsTable = document.select("table").attr("class", "wikitable sortable jquery-tablesorter");
        while (esH3.iterator().hasNext()) {
            if (index >= 64) {
                break;
            }
            Element eH3 = esH3.iterator().next();
            Elements esSpan = eH3.select("span");
            if (!esSpan.iterator().hasNext()) {
                esH3 = esH3.next();
                continue;
            }
            String idSpan = esSpan.first().id();
            if (listIdH2.contains(idSpan) && !idSpan.equals(idSpanHaNoi)) {
                esH3 = esH3.next();
                continue;
            }
            String tinh = esSpan.get(1).text();

            Element eTable = elementsTable.get(index);

            Map<Integer, List<String>> listMap = new HashMap<>();
            listMap = getDataTable(eTable, 5, 1);

            for (int i = 0; i < listMap.size(); i++) {
                List<String> list = listMap.get(i);
                HistoricalSite historicalSite = new HistoricalSite(index);
                try {
                    historicalSite.setTen(Utils.removeComments(list.get(0)));
                    historicalSite.setDiaDiem(Utils.removeComments(list.get(1) + ", " + tinh));
                    historicalSite.setLoaiDiTich(Utils.removeComments(list.get(2)));
                    historicalSite.setNamCN(Utils.removeComments(list.get(3)));
                    historicalSite.setMieuTa(Utils.removeComments(list.get(4)));
                    historicalSite.setKieu("historical-site");
                    try {
                        String linkHistoricalSite = list.get(5);
                        if (linkHistoricalSite.contains("/wiki/")) {
                            historicalSite.setMoTa(Utils.removeComments(getDescription(ConfigHtml.WIKIPEDIA_URL + linkHistoricalSite)));
                        }
                    } catch (Exception e) {

                    }
                    historicalSites.add(historicalSite);
                    index++;
                } catch (IndexOutOfBoundsException e) {
                    e.printStackTrace();
                }
            }
            esH3 = esH3.next();
        }
        return historicalSites;
    }

    @Override
    public List<HistoricEvent> collectionDataHistoricEvent() throws IOException {
        List<HistoricEvent> historicEvents = new ArrayList<>();
        exceptionHistoricEvents = new ArrayList<>();
        exceptionHistoricEvents.add("Việt Nam Dân chủ Cộng hòa");
        exceptionHistoricEvents.add("Thời kỳ thống nhất");
        exceptionHistoricEvents.add("Thời kỳ đổi mới");
        exceptionHistoricEvents.add("Thời kỳ Bắc thuộc lần 4");

        Document document = getDocument(ConfigHtml.WIKIPEDIA_URL + "/wiki/Các_cuộc_chiến_tranh_Việt_Nam_tham_gia");
        Element eId = document.getElementById("mw-content-text");
        Element eClass = eId.getElementsByClass("mw-parser-output").first();
        Elements esH2 = eClass.select("h2");
        Elements esTable = eClass.select("table").attr("class", "wikitable");

        int index = 1;
        String thoiKy = null;

        while (esH2.iterator().hasNext()) {
            Element eH2 = esH2.iterator().next();
            if (eH2.text().contains("Tham khảo"))
                break;
            boolean checkContainElementH2 = false;

            int k = 1;
            while (k < exceptionHistoricEvents.size()) {
                if (eH2.text().contains(exceptionHistoricEvents.get(k))) {
                    checkContainElementH2 = true;
                    break;
                }
                k++;
            }

            if (eH2.text().contains("[sửa | sửa mã nguồn]") && (eH2.text().contains("(") || checkContainElementH2) && !eH2.text().contains(exceptionHistoricEvents.get(0))) {
                thoiKy = Utils.removeComments(eH2.text());
                System.out.println(thoiKy);
                Element eTable = null;

                while (esTable.iterator().hasNext()) {
                    Element eTableSelect = esTable.iterator().next();
                    if (eTableSelect.attr("width").equals("70%|") || eTableSelect.attr("width").equals("80%|")) {
                        eTable = eTableSelect;
                        esTable = esTable.next();
                        break;
                    }
                    esTable = esTable.next();
                }

                if (eTable != null) {

                    Map<Integer, List<String>> listMap = new HashMap<>();
                    listMap = getDataTable(eTable, 4, 1);

                    for (int i = 0; i < listMap.size(); i++) {
                        List<String> list = listMap.get(i);
                        WarEvent warEvent = new WarEvent(index);
                        warEvent.setTen(Utils.removeComments(list.get(0).substring(0, list.get(0).charAt('('))));
                        warEvent.setThoiKy(thoiKy);
                        warEvent.setKieu("war-event");
                        warEvent.setThoiGian(Utils.removeComments(list.get(0).substring(list.get(0).charAt('(') + 1, list.get(0).charAt(')') - 1)));
                        warEvent.setLucLuong(Utils.removeComments(list.get(1)));
                        warEvent.setDoiPhuong(Utils.removeComments(list.get(2)));
                        warEvent.setKetQua(Utils.removeComments(list.get(3)));
                        try {
                            String linkWarEvent = list.get(4);
                            if (linkWarEvent.contains("/wiki/")) {
                                warEvent.setMoTa(Utils.removeComments(getDescription(ConfigHtml.WIKIPEDIA_URL + linkWarEvent)));
                            }
                        } catch (Exception e) {
                        }
                        historicEvents.add(warEvent);
                        index++;
                    }
                }
            }

            esH2 = esH2.next();
        }
        return historicEvents;
    }

    private String getDescription(String url) throws IOException {
        StringBuffer stringBuffer = new StringBuffer("");
        Document documentDescription = getDocument(url);
        Element elementId = documentDescription.getElementById("mw-content-text");
        Element elementClass = elementId.getElementsByClass("mw-parser-output").first();
        Elements elementsChildren = elementClass.children();

        while (elementsChildren.iterator().hasNext()) {
            Element elementChildren = elementsChildren.iterator().next();
            if (elementChildren.is("h2")) {
                if (elementChildren.text().contains("Chú thích") || elementChildren.text().contains("Liên kết ngoài"))
                    break;
            }
            if (elementChildren.is("p")) {
                Elements elementsSpanDescription = elementChildren.select("span");
                if (!elementsSpanDescription.iterator().hasNext()) {
                    stringBuffer.append(elementChildren.text());
                }
            }
            elementsChildren = elementsChildren.next();
        }
        return stringBuffer.toString();
    }

    private Map<Integer, List<String>> getDataTable(Element eTable, int nColumn, int cLink) {
        Element eTbody = eTable.selectFirst("tbody");
        Elements esTr = eTbody.select("tr");

        Map<Integer, List<String>> hashMap = new HashMap<>();
        int[] number = new int[nColumn];
        int index = 0;

        for (int i = 0; i < number.length; i++) {
            number[i] = 0;
        }

        esTr = esTr.next();

        while (esTr.iterator().hasNext()) {
            Element eTr = esTr.iterator().next();
            Elements esTd = eTr.select("td");

            List<String> list = new ArrayList<>();
            int k = 0;
            int num = 0;

            for (int i = 0; i < nColumn; i++) {
                if (number[i] == 0) {
                    try {
                        String rowspan = esTd.get(i).attr("rowspan");
                        number[i] = Integer.parseInt(rowspan);
                    } catch (Exception e) {
                    }
                    System.out.print(esTd.get(k).text());
                    list.add(esTd.get(k).text());
                    k++;
                } else {
                    if (i < cLink - 1) {
                        num++;
                    }
                    number[i]--;
                    System.out.print(hashMap.get(index - 1).get(i));
                    list.add(hashMap.get(index - 1).get(i));
                }

                if (k >= esTd.size() || i == nColumn - 1) {
                    System.out.println(cLink + " " + num);
                    try {
                        list.add(esTd.get(cLink - 1 - num).selectFirst("a").attr("href"));
                        System.out.print(esTd.get(cLink - 1 - num).selectFirst("a").attr("href"));
                    } catch (Exception e) {

                    }
                    break;
                }
                System.out.println();
            }

            hashMap.put(index, list);
            index++;
            esTr = esTr.next();
        }
        return hashMap;
    }
}
