package controller.datacollectioncontroller.datacollectioncontrollerimpl;

import controller.datacollectioncontroller.IDataCollectionController;
import entity.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import utils.Utils;
import utils.configs.ConfigHtml;

import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

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
        Element elementId = document.getElementById("mw-content-text");
        Elements elementsDl = elementId.select("dl");

//        while (elementsDl.iterator().hasNext()) {
//            Element elementDl = elementsDl.iterator().next();
//            Element elementDd = elementDl.selectFirst("dd");
//            if (elementDd != null) {
//                String str = Utils.removeComments(elementDl.text());
//                String tinh = str.split(":")[0];
//                str = str.replace(tinh + ":", "").trim();
//                StringBuffer s = new StringBuffer("");
//                boolean checkNumber = false;
//                boolean checkBracket = false;
//                List<String> list = new ArrayList<>();
//                for (int i = 0; i < str.length(); i++) {
//                    String si = String.valueOf(str.charAt(i));
//                    if (si.equals("(")) {
//                        checkBracket = true;
//                    }
//                    if (si.equals(")")) {
//                        checkBracket = false;
//                    }
//                    if (checkNumber == false) {
//                        if (Utils.isNumeric(si)) {
//                            if (s.length() != 1 && s.length() != 0) {
//                                list.add(String.valueOf(s).trim());
//                            }
//                            s = new StringBuffer("");
//                            s.append(si);
//                            checkNumber = true;
//                        } else {
//                            if (checkBracket == true) {
//                                s.append(si);
//                            } else {
//                                if (si.equals(",") || si.equals(";")) {
//                                    if (s.length() != 1 && s.length() != 0) {
//                                        list.add(String.valueOf(s).trim());
//                                    }
//                                    s = new StringBuffer("");
//                                    checkNumber = false;
//                                    checkBracket = false;
//                                } else {
//                                    s.append(si);
//                                }
//                            }
//                        }
//                    } else {
//                        if (si.equals(",") || si.equals(";")) {
//                            if (s.length() != 1 && s.length() != 0) {
//                                list.add(String.valueOf(s).trim());
//                            }
//                            s = new StringBuffer("");
//                            checkNumber = false;
//                            checkBracket = false;
//                        } else {
//                            s.append(si);
//                        }
//                    }
//                }
//                if (s.length() != 1 && s.length() != 0) {
//                    list.add(String.valueOf(s).trim());
//                }
//                String address = "";
//                for (String se : list) {
//                    if (Utils.isNumeric(String.valueOf(se.charAt(0)))) {
//                        System.out.println("ngay  " + se);
//                    } else {
//                        int bracketStart = se.indexOf("(");
//                        if (bracketStart == -1) {
//                            System.out.println("ten  " + se);
//                        } else {
//                            int bracketEnd = se.indexOf(")");
//                            System.out.println("ten  " + se.substring(0, bracketStart));
//                            System.out.println("dia diem  " + se.substring(bracketStart + 1, bracketEnd));
//                        }
//                    }
//                }
//            }
//            elementsDl = elementsDl.next();
//        }
//        Element elementUl = elementId.select("ul").get(10);
//        Elements elementsLi = elementUl.select("li");
//        while (elementsLi.iterator().hasNext()) {
//            Element elementLi = elementsLi.iterator().next();
//            System.out.println(elementLi.text());
//            String str = elementLi.text();
//
//            String tinh = str.split(":")[0];
//            str = str.replace(tinh + ":", "").trim();
//            StringBuffer s = new StringBuffer("");
//            boolean checkNumber = false;
//            boolean checkBracket = false;
//            List<String> list = new ArrayList<>();
//
//            for (int i = 0; i < str.length(); i++) {
//                String si = String.valueOf(str.charAt(i));
//                if (si.equals("(")) {
//                    checkBracket = true;
//                }
//                if (si.equals(")")) {
//                    checkBracket = false;
//                }
//                if (checkNumber == false) {
//                    if (Utils.isNumeric(si)) {
//                        if (checkBracket == false) {
//                            if (s.length() != 1) {
//                                list.add(String.valueOf(s).trim());
//                            }
//                            s = new StringBuffer("");
//                            s.append(si);
//                            checkNumber = true;
//                        } else {
//                            s.append(si);
//                        }
//                    } else {
//                        if (checkBracket == true) {
//                            s.append(si);
//                        } else {
//                            if (si.equals(",") || si.equals(";")) {
//                                if (s.length() != 1) {
//                                    list.add(String.valueOf(s).trim());
//                                }
//                                s = new StringBuffer("");
//                                checkNumber = false;
//                                checkBracket = false;
//                            } else {
//                                s.append(si);
//                            }
//                        }
//                    }
//                } else {
//                    if (si.equals(",") || si.equals(";")) {
//                        if (s.length() != 1) {
//                            list.add(String.valueOf(s).trim());
//                        }
//                        s = new StringBuffer("");
//                        checkNumber = false;
//                        checkBracket = false;
//                    } else {
//                        s.append(si);
//                    }
//                }
//            }
//            if (s.length() != 1) {
//                list.add(String.valueOf(s).trim());
//            }
//            for (String se : list) {
//                if (Utils.isNumeric(String.valueOf(se.charAt(0)))) {
//                    System.out.println(se);
//                } else {
//                    int bracketStart = se.indexOf("(");
//                    if (bracketStart == -1) {
//                        System.out.println(se);
//                    } else {
//                        int bracketEnd = se.indexOf(")");
//                        System.out.println(se.substring(0, bracketStart));
//                        System.out.println(se.substring(bracketStart + 1, bracketEnd));
//                    }
//                }
//            }
//
//            elementsLi = elementsLi.next();
//        }
        Element elementTable = elementId.select("table").get(1);
        Element elementTbody = elementTable.selectFirst("tbody");
        Elements elementsTr = elementTbody.select("tr");
        int numberDay = 0;
        String time = null;

        elementsTr = elementsTr.next();

        while (elementsTr.iterator().hasNext()) {
            Element elementTr = elementsTr.iterator().next();
            Elements elementsTd = elementTr.select("td");

            CulturalFestival culturalFestival = new CulturalFestival(index);
            String linkCulturalFestival = null;

            if (numberDay == 0) {
                try {
                    numberDay = Integer.parseInt(elementsTd.get(0).attr("rowspan"));
                } catch (Exception e) {

                }
                time = elementsTd.get(0).text();
                culturalFestival.setDiaDiem(elementsTd.get(1).text());
                culturalFestival.setTen(elementsTd.get(2).text());
                linkCulturalFestival = elementsTd.get(2).selectFirst("a").attr("href");
                culturalFestival.setThoiDiemToChucLanDau(elementsTd.get(3).text());
                try {
                    culturalFestival.setGhiChu(elementsTd.get(4).text());
                } catch (Exception e) {

                }
            } else {
                culturalFestival.setDiaDiem(elementsTd.get(0).text());
                culturalFestival.setTen(elementsTd.get(1).text());
                linkCulturalFestival = elementsTd.get(1).selectFirst("a").attr("href");
                culturalFestival.setThoiDiemToChucLanDau(elementsTd.get(2).text());
                culturalFestival.setGhiChu(elementsTd.get(3).text());
            }
            culturalFestival.setThoiGian(time);
            if(linkCulturalFestival.contains("/wiki/")){
                culturalFestival.setMoTa(getDescription(ConfigHtml.WIKIPEDIA_URL + linkCulturalFestival));
            }

            culturalFestivals.add(culturalFestival);
            System.out.println(culturalFestival.getTen());
            index++;
            if (numberDay > 0) numberDay--;
            elementsTr = elementsTr.next();
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

            historicalDynasty.setTenTrieuDai(elementsTd.first().text());
            System.out.println(elementsTd.first().text());
            String linkHistoricalDynasty = elementsTd.first().select("a").first().attr("href");
            if (linkHistoricalDynasty.contains("/wiki/")) {
                String moTa = Utils.removeComments(getDescription(ConfigHtml.WIKIPEDIA_URL + linkHistoricalDynasty));
                StringTokenizer stringTokenizer = new StringTokenizer(moTa, ".");
                StringTokenizer listToken = stringTokenizer;
                while (listToken.hasMoreTokens()){
                    String token = listToken.nextToken();
                    if(token.contains("thành lập")){
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
            Element element = elementsTable.iterator().next();
            if (!(element.attr("style").equals("width:100%; font-size:90%; text-align:center; border:1px solid lavender;") || element.attr("style").equals("width:100%; font-size:90%; text-align:center; border:lavender;"))) {
                elementsTable = elementsTable.next();
                continue;
            }
            Element elementTbody = element.select("tbody").first();
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
            elementsTr = elementsTr.next();
            while (elementsTr.iterator().hasNext()) {
                Element elementTr = elementsTr.iterator().next();
                if (elementTr == null || elementTr.select("td") == null) {
                    continue;
                }

                Elements elementsTd = elementTr.select("td");
                Dominator dominator = new Dominator(index);

                try {
                    int i = 1;
                    dominator.setVaiTro(typeDominator);
                    String linkDominator = elementsTd.get(i).select("a").first().attr("href");
                    dominator.setTen(Utils.removeComments(elementsTd.get(i++).text()));
                    dominator.setMieuHieu(Utils.removeComments(elementsTd.get(i++).text()));
                    dominator.setThuyHieu(Utils.removeComments(elementsTd.get(i++).text()));
                    dominator.setNienHieu(Utils.removeComments(elementsTd.get(i++).text()));
                    dominator.setTenHuy(Utils.removeComments(elementsTd.get(i++).text()));
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
                    if (elementsTd.size() == 9) {
                        dominator.setTheThu("");
                        dominator.setTriVi(Utils.removeComments(elementsTd.get(i++).text()) + Utils.removeComments(elementsTd.get(i++).text()) + Utils.removeComments(elementsTd.get(i++).text()));
                    } else {
                        dominator.setTheThu(Utils.removeComments(elementsTd.get(i++).text()));
                        if (elementsTd.size() == 8) {
                            dominator.setTriVi(Utils.removeComments(elementsTd.get(i++).text()));
                        } else {
                            dominator.setTriVi(Utils.removeComments(elementsTd.get(i++).text()) + Utils.removeComments(elementsTd.get(i++).text()) + Utils.removeComments(elementsTd.get(i++).text()));
                        }
                    }
                } catch (Exception e) {

                }
                historicalFigures.add(dominator);
                elementsTr = elementsTr.next();
                index++;
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
        Elements elementsH3 = document.select("h3");
        Elements elementsH2 = document.select("h2");

        int sizeElementsH2 = elementsH2.size();
        List<String> listIdH2 = new ArrayList<>();

        for (int i = 1; i < sizeElementsH2; i++) {
            Element elementH2 = elementsH2.get(i);
            Elements elementsSpan = elementH2.select("span");
            if (!elementsSpan.iterator().hasNext()) {
                elementsH2 = elementsH2.next();
                continue;
            }
            listIdH2.add(elementsSpan.first().id());
        }

        Elements elementsTable = document.select("table").attr("class", "wikitable sortable jquery-tablesorter");
        while (elementsH3.iterator().hasNext()) {
            if (index >= 64) {
                break;
            }
            Element elementH3 = elementsH3.iterator().next();
            Elements elementsSpan = elementH3.select("span");
            if (!elementsSpan.iterator().hasNext()) {
                elementsH3 = elementsH3.next();
                continue;
            }
            String idSpan = elementsSpan.first().id();
            if (listIdH2.contains(idSpan) && !idSpan.equals(idSpanHaNoi)) {
                elementsH3 = elementsH3.next();
                continue;
            }
            String tinh = elementsSpan.get(1).text();

            Element elementTable = elementsTable.get(index);
            Element elementTbody = elementTable.select("tbody").first();
            Elements elementsTr = elementTbody.select("tr");
            elementsTr = elementsTr.next();
            while (elementsTr.iterator().hasNext()) {
                Element elementTr = elementsTr.iterator().next();
                Elements elementsTd = elementTr.select("td");
                if (!elementsTd.iterator().hasNext()) {
                    elementsTr = elementsTr.next();
                    continue;
                }

                HistoricalSite historicalSite = new HistoricalSite(index);
                index++;

                if (!idSpan.equals(idSpanNinhBinh)) {
                    try {
                        historicalSite.setTenDiTich(elementsTd.get(0).text());
                    } catch (Exception e) {
                        System.out.println(tinh);
                        System.out.println(elementsTr);
                    }
                    historicalSite.setDiaDiem(elementsTd.get(1).text() + ", " + tinh);
                    historicalSite.setGhiChu(elementsTd.get(2).text());
                    try {
                        historicalSite.setNamCN(elementsTd.get(3).text());
                    } catch (Exception e) {
                    }
                    try {
                        String linkHistoricalSite = elementsTd.get(0).select("a").first().attr("href");
                        if (linkHistoricalSite.contains("/wiki/")){
                            System.out.println();
                            System.out.println("****************" + historicalSite.getTenDiTich());
                            System.out.println();
                            historicalSite.setMoTa(getDescription(ConfigHtml.WIKIPEDIA_URL + linkHistoricalSite));
                        }
                    } catch (Exception e) {

                    }
                } else {
                    historicalSite.setTenDiTich(elementsTd.get(1).text());
                    historicalSite.setDiaDiem(elementsTd.get(2).text() + ", " + tinh);
                    historicalSite.setMieuTa(elementsTd.get(3).text());
                    try {
                        String linkHistoricalSite = elementsTd.get(1).select("a").first().attr("href");
                        if (linkHistoricalSite.contains("/wiki/")) {
                            System.out.println();
                            System.out.println("****************" + historicalSite.getTenDiTich());
                            System.out.println();
                            historicalSite.setMoTa(getDescription(ConfigHtml.WIKIPEDIA_URL + linkHistoricalSite));
                        }
                    } catch (Exception e) {

                    }
                }
                historicalSites.add(historicalSite);
                elementsTr = elementsTr.next();
            }
            elementsH3 = elementsH3.next();
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
        Element elementId = document.getElementById("mw-content-text");
        Element elementClass = elementId.getElementsByClass("mw-parser-output").first();
        Elements elementsH2 = elementClass.select("h2");
        Elements elementsTable = elementClass.select("table").attr("class", "wikitable");

        int index = 1;
        String thoiKy = null;

        while (elementsH2.iterator().hasNext()) {
            Element elementH2 = elementsH2.iterator().next();
            if (elementH2.text().contains("Tham khảo"))
                break;
            boolean checkContainElementH2 = false;

            int k = 1;
            while (k < exceptionHistoricEvents.size()) {
                if (elementH2.text().contains(exceptionHistoricEvents.get(k))) {
                    checkContainElementH2 = true;
                    break;
                }
                k++;
            }

            if (elementH2.text().contains("[sửa | sửa mã nguồn]") && (elementH2.text().contains("(") || checkContainElementH2) && !elementH2.text().contains(exceptionHistoricEvents.get(0))) {
                thoiKy = Utils.removeComments(elementH2.text());
                System.out.println(thoiKy);
                Element elementTable = null;

                while (elementsTable.iterator().hasNext()) {
                    Element elementTableSelect = elementsTable.iterator().next();
                    if (elementTableSelect.attr("width").equals("70%|") || elementTableSelect.attr("width").equals("80%|")) {
                        elementTable = elementTableSelect;
                        elementsTable = elementsTable.next();
                        break;
                    }
                    elementsTable = elementsTable.next();
                }

                if (elementTable != null) {
                    Element elementTbody = elementTable.selectFirst("tbody");
                    Elements elementsTr = elementTbody.select("tr");
                    System.out.println(elementsTr.first().text());
                    elementsTr = elementsTr.next();
                    String doiPhuong = null;
                    String ketQua = null;
                    String lucLuong = null;
                    int numberDoiPhuong = 0;
                    int numberKetQua = 0;
                    int numberLucLuong = 0;

                    while (elementsTr.iterator().hasNext()) {
                        Element elementTr = elementsTr.iterator().next();
                        Elements elementsTd = elementTr.select("td");
                        WarEvent warEvent = new WarEvent(index);
                        index++;

                        warEvent.setThoiKy(thoiKy);
                        String tenSuKien = elementsTd.get(0).text();
                        warEvent.setTenSuKien(tenSuKien);
                        try{
                            String linkWarEvent = elementsTd.get(0).select("a").first().attr("href");
                            if(linkWarEvent.contains("/wiki/")){
                                warEvent.setMoTa(getDescription(ConfigHtml.WIKIPEDIA_URL + linkWarEvent));
                            }
                        } catch (Exception e){

                        }

                        if (numberLucLuong == 0) {
                            try {
                                numberLucLuong = Integer.parseInt(elementsTd.get(1).attr("rowspan"));
                            } catch (Exception e) {

                            }
                            lucLuong = elementsTd.get(1).text();
                            if (numberDoiPhuong == 0) {
                                try {
                                    numberDoiPhuong = Integer.parseInt(elementsTd.get(2).attr("rowspan"));
                                } catch (Exception e) {

                                }
                                doiPhuong = elementsTd.get(2).text();
                                if (numberKetQua == 0) {
                                    try {
                                        numberKetQua = Integer.parseInt(elementsTd.get(3).attr("rowspan"));
                                    } catch (Exception e) {

                                    }
                                    System.out.println(numberLucLuong + " " + numberDoiPhuong + " " + numberKetQua);
                                    ketQua = elementsTd.get(3).text();
                                }
                            } else {
                                if (numberKetQua == 0) {
                                    try {
                                        numberKetQua = Integer.parseInt(elementsTd.get(2).attr("rowspan"));
                                    } catch (Exception e) {

                                    }
                                    System.out.println(numberLucLuong + " " + numberDoiPhuong + " " + numberKetQua);
                                    ketQua = elementsTd.get(2).text();
                                }
                            }
                        } else {
                            if (numberDoiPhuong == 0) {
                                try {
                                    numberDoiPhuong = Integer.parseInt(elementsTd.get(1).attr("rowspan"));
                                } catch (Exception e) {

                                }
                                doiPhuong = elementsTd.get(1).text();
                                if (numberKetQua == 0) {
                                    try {
                                        numberKetQua = Integer.parseInt(elementsTd.get(2).attr("rowspan"));
                                    } catch (Exception e) {

                                    }
                                    System.out.println(numberLucLuong + " " + numberDoiPhuong + " " + numberKetQua);
                                    ketQua = elementsTd.get(2).text();
                                }
                            } else {
                                if (numberKetQua == 0) {
                                    try {
                                        numberKetQua = Integer.parseInt(elementsTd.get(1).attr("rowspan"));
                                    } catch (Exception e) {

                                    }
                                    System.out.println(numberLucLuong + " " + numberDoiPhuong + " " + numberKetQua);
                                    ketQua = elementsTd.get(1).text();
                                }
                            }
                        }

                        if (numberDoiPhuong > 0) numberDoiPhuong--;
                        if (numberLucLuong > 0) numberLucLuong--;
                        if (numberKetQua > 0) numberKetQua--;

                        if (tenSuKien.equals("")) {
                            elementsTr = elementsTr.next();
                            continue;
                        }
                        String thoiGian = tenSuKien.substring(tenSuKien.indexOf("(") + 1, tenSuKien.indexOf(")"));
                        warEvent.setThoiGian(thoiGian);
                        warEvent.setLucLuong(lucLuong);
                        warEvent.setDoiPhuong(doiPhuong);
                        warEvent.setKetQua(ketQua);
                        historicEvents.add(warEvent);
                        elementsTr = elementsTr.next();
                    }
                }
            }

            elementsH2 = elementsH2.next();
        }
        return historicEvents;
    }
}
