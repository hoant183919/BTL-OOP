package datacollectioncontroller.datacollectioncontrollerimpl;

import common.exception.*;
import datamanipulation.*;
import datamanipulation.datamanipulationimpl.*;
import datacollectioncontroller.IDataCollectionController;

import entity.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import utils.configs.ConfigDataType;
import utils.configs.ConfigHtml;
import utils.configs.ConfigResourceData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

import static utils.configs.ConfigResourceData.NAME_FILE;

public class DataCollectionNguoiKeSuController implements IDataCollectionController {

    /**
     * Thu thập dữ liệu về các lễ hội Việt Nam
     *
     * @return Danh sách các lễ hội
     * @throws IOException
     * @throws CulturalFestivalDataCollectionException
     */
    @Override
    public List<CulturalFestival> collectionDataCulturalFestival() throws IOException, CulturalFestivalDataCollectionException {
        return null;
    }

    /**
     * Thu thập dữ liệu về các triều đại lịch sử Việt Nam
     *
     * @return Danh sách các triều đại lịch sử Việt Nam
     * @throws IOException
     * @throws HistoricalDynastyDataCollectionException
     */
    @Override
    public List<HistoricalDynasty> collectionDataHistoricalDynasty() throws IOException {
        List<HistoricalDynasty> historicalDynasties = new ArrayList<>();
        List<String> listDynasties = new ArrayList<>();
        int index = 1;
        int startWeb = 0;
        while (startWeb <= 150) {
            String url = ConfigHtml.NGUOIKESU_URL + "dong-lich-su";
            if (startWeb != 0) {
                url += "?start=" + String.valueOf(startWeb);
            }
            Document document = getDocument(url);
            Element elementId = document.getElementById("content");
            Elements elementsDiv = elementId.select("div").get(1).select("div").get(2).select("div");
            while (elementsDiv.iterator().hasNext()) {
                try {
                    Element elementDiv = elementsDiv.iterator().next();
                    if (elementDiv.attr("class").equals("com-content-category-blog__item blog-item")) {
                        Element elementDivChildren = elementDiv.select("div").first();
                        String tenNhanVat = elementDivChildren.select("div").first().select("a").first().text();
                        if (!tenNhanVat.contains("Kỷ") && !tenNhanVat.contains("Thuộc") && tenNhanVat.contains("-")) {
                            String ten = elementDivChildren.select("dl").first().select("dd").first().text();
                            if (!listDynasties.contains(ten)) {
                                listDynasties.add(ten);
                                HistoricalDynasty historicalDynasty = new HistoricalDynasty(index);
                                String linkDescription = elementDivChildren.select("dl").first().select("dd").first().select("a").first().attr("href");
                                String moTa = getDescriptionHistoricalDynasty(ConfigHtml.NGUOIKESU_URL + linkDescription.replaceFirst("/", ""));
                                historicalDynasty.setTen(ten);
                                historicalDynasty.setMoTa(moTa);
                                historicalDynasty.setNguonDuLieu(ConfigHtml.NGUOIKESU_URL);

                                try {
                                    StringTokenizer stringTokenizer = new StringTokenizer(moTa, ".");
                                    String firstSentence = stringTokenizer.nextToken();
                                    String str = firstSentence.substring(firstSentence.indexOf("(") + 1, firstSentence.indexOf(")")).replaceAll(" ", "");
                                    System.out.println(str);
                                    StringTokenizer stringTokenizer1 = new StringTokenizer(str, ",");
                                    while (stringTokenizer1.hasMoreTokens()) {
                                        String time = stringTokenizer1.nextToken();
                                        String regex = "(.)*(\\d)(.)*";
                                        Pattern pattern = Pattern.compile(regex);
                                        if (time.contains("-") && pattern.matcher(time).matches()) {
                                            StringTokenizer stringTokenizerTime = new StringTokenizer(time, "-");
                                            historicalDynasty.setThoiGianBatDau(stringTokenizerTime.nextToken());
                                            historicalDynasty.setThoiGianKetThuc(stringTokenizerTime.nextToken());
                                            System.out.println(historicalDynasty.getThoiGianBatDau());
                                            System.out.println(historicalDynasty.getThoiGianKetThuc());
                                            break;
                                        }
                                    }
                                } catch (Exception e) {

                                }

                                try {
                                    StringTokenizer stringTokenizer = new StringTokenizer(moTa, ".");
                                    System.out.println("count token : " + stringTokenizer.countTokens());
                                    while (stringTokenizer.hasMoreTokens()) {
                                        String sentence = stringTokenizer.nextToken();
                                        if (sentence.contains("đô")) {
                                            System.out.println(sentence);
                                            String[] strings = sentence.split("đô");
                                            String checkToken = strings[0];
                                            if (checkToken.contains("đóng") || checkToken.contains("kinh")) {
                                                String str = strings[1].trim();
                                                String[] sAlphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "K", "L", "M", "N", "O", "Ô", "P", "Q", "R", "S", "T", "U", "Ư", "V", "X", "Y"};
                                                int k = 0;
                                                String kinhDo = "";
                                                while (k < sAlphabet.length) {
                                                    if (String.valueOf(str.charAt(0)).equals(sAlphabet[k])) {
                                                        String[] strings1 = str.split(" ");
                                                        int t = 1;
                                                        String checkString = strings1[1];
                                                        while (t < checkString.length()) {
                                                            int d = 0;
                                                            while (d < sAlphabet.length) {
                                                                if (String.valueOf(checkString.charAt(t)).equals(sAlphabet[d])) {
                                                                    checkString = checkString.substring(0, t);
                                                                    t = checkString.length();
                                                                    break;
                                                                }
                                                                d++;
                                                            }
                                                            t++;
                                                        }
                                                        kinhDo += strings1[0] + " " + checkString;
                                                        break;
                                                    }
                                                    k++;
                                                }
                                                if (kinhDo.equals("")) {
                                                    String[] strings1 = str.split(" ");
                                                    char c = strings1[1].charAt(0);
                                                    boolean b = false;
                                                    int l = 0;
                                                    while (l < sAlphabet.length) {
                                                        if (String.valueOf(c).equals(sAlphabet[l])) {
                                                            b = true;
                                                            break;
                                                        }
                                                        l++;
                                                    }
                                                    System.out.println(b);
                                                    if (b) {
                                                        int t = 1;
                                                        String checkString = strings1[2];
                                                        while (t < checkString.length()) {
                                                            int d = 0;
                                                            while (d < sAlphabet.length) {
                                                                if (String.valueOf(checkString.charAt(t)).equals(sAlphabet[d])) {
                                                                    checkString = checkString.substring(0, t);
                                                                    t = checkString.length();
                                                                    break;
                                                                }
                                                                d++;
                                                            }
                                                            t++;
                                                        }
                                                        kinhDo += strings1[1] + " " + checkString;
                                                    }
                                                }
                                                if (!kinhDo.equals("")) {
                                                    System.out.println(kinhDo);
                                                    historicalDynasty.setKinhDo(kinhDo);
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                } catch (Exception e) {

                                }
                                historicalDynasties.add(historicalDynasty);
                                index++;
                                System.out.println("T: " + ten);
                                System.out.println("MT: " + moTa);
                                System.out.println("******************************");
                            }
                        }
                    }
                } catch (Exception e) {

                }
                elementsDiv = elementsDiv.next();
            }
            startWeb += 6;
        }
        return historicalDynasties;
    }

    /**
     * Lấy thông tin mô tả về triều đại lịch sử
     * @param url - Đường dẫn đến trang mô tả đó
     * @return Chuỗi mô tả
     * @throws IOException
     */
    private String getDescriptionHistoricalDynasty(String url) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        Document document = getDocument(url);

        Element elementId = document.getElementById("content");
        Element elementDiv = elementId.select("div").get(1).select("div").first();
        Elements elementsP = elementDiv.select("p");
        while (elementsP.iterator().hasNext()) {
            Element elementP = elementsP.iterator().next();
            stringBuffer.append(elementP.text());
            elementsP = elementsP.next();
        }
        return stringBuffer.toString();
    }

    /**
     * Thu thập dữ liệu về các nhân vật lịch sử Việt Nam
     *
     * @return Danh sách các nhân vât lịch sử Việt Nam
     * @throws IOException
     * @throws HistoricalFigureDataCollectionException
     */
    @Override
    public List<HistoricalFigure> collectionDataHistoricalFigure() throws IOException, HistoricalFigureDataCollectionException {
        List<HistoricalFigure> historicalFigures = new ArrayList<>();
        int index = 1;
        List<HistoricalFigure> nationalHeros = collectionDataNationalHero(index);
        for (HistoricalFigure historicalFigure : nationalHeros) {
            historicalFigures.add(historicalFigure);
        }
        List<HistoricalFigure> culturalCelebrities = collectionDataCulturalCelebrity(index);
        for (HistoricalFigure historicalFigure : culturalCelebrities) {
            historicalFigures.add(historicalFigure);
        }
        List<Dominator> dominators = collectionDataDominator(index);
        for (Dominator dominator : dominators) {
            historicalFigures.add(dominator);
        }
        return historicalFigures;
    }

    /**
     * Thu thập dữu liệu về các anh hùng dân tộc Việt Nam
     * @param index - chỉ số bắt đầu của id
     * @return Danh sách thông tin về các anh hùng dân tộc Việt Nam
     * @throws IOException
     * @throws HistoricalFigureDataCollectionException
     */
    private List<HistoricalFigure> collectionDataNationalHero(int index) throws IOException, HistoricalFigureDataCollectionException {
        List<HistoricalFigure> historicalFigures = new ArrayList<>();
        int startWeb = 0;
        while (startWeb <= 10) {
            String url = ConfigHtml.NGUOIKESU_URL + "anh-hung-dan-toc?types[0]=1";
            if (startWeb != 0) {
                url += "&start=" + String.valueOf(startWeb);
            }
            Document document = getDocument(url);
            Element elementId = document.getElementById("content");
            Element elementDiv = elementId.select("div").select("div").get(2).select("div").first();
            Element elementUl = elementDiv.select("ul").first();
            Elements elementsLi = elementUl.select("li");
            while (elementsLi.iterator().hasNext()) {
                try {
                    Element elementLi = elementsLi.iterator().next();
                    Element elementH3 = elementLi.select("h3").first();
                    Element elementSpan = elementLi.select("span").first();
                    Element elementA = elementLi.select("a").first();
                    String moTa = "";
                    Elements elementsP = elementSpan.select("p");
                    while (elementsP.iterator().hasNext()) {
                        Element elementP = elementsP.iterator().next();
                        moTa += elementP.text();
                        elementsP = elementsP.next();
                    }
                    HistoricalFigure historicalFigure = new HistoricalFigure(index);
                    historicalFigure.setNguonDuLieu(ConfigHtml.NGUOIKESU_URL);
                    historicalFigure.setTen(elementH3.text());
                    historicalFigure.setMoTa(moTa);
                    historicalFigures.add(historicalFigure);
                    index++;
                    System.out.println(elementH3.text());
                    System.out.println(elementA.attr("href"));
                    System.out.println(moTa);
                    System.out.println("*****************");
                } catch (Exception e) {
                    throw new HistoricalFigureDataCollectionException();
                }
                elementsLi = elementsLi.next();
            }
            startWeb += 10;
        }
        return historicalFigures;
    }

    /**
     * Thu thập dữ liệu về các danh nhân văn hoá Việt Nam
     * @param index - chỉ số bắt đầu của id
     * @return Danh sách thông tin danh nhân văn hoá Việt Nam
     * @throws IOException
     * @throws HistoricalFigureDataCollectionException
     */
    private List<HistoricalFigure> collectionDataCulturalCelebrity(int index) throws IOException, HistoricalFigureDataCollectionException {
        List<HistoricalFigure> historicalFigures = new ArrayList<>();
        int startWeb = 0;
        while (startWeb <= 10) {
            String url = ConfigHtml.NGUOIKESU_URL + "danh-nhan-van-hoa?types[0]=1";
            if (startWeb != 0) {
                url += "&start=" + String.valueOf(startWeb);
            }
            Document document = getDocument(url);
            Element elementId = document.getElementById("content");
            Element elementDiv = elementId.select("div").select("div").get(2).select("div").first();
            Element elementUl = elementDiv.select("ul").first();
            Elements elementsLi = elementUl.select("li");
            while (elementsLi.iterator().hasNext()) {
                try {
                    Element elementLi = elementsLi.iterator().next();
                    Element elementH3 = elementLi.select("h3").first();
                    Element elementSpan = elementLi.select("span").first();
                    Element elementA = elementLi.select("a").first();
                    String moTa = "";
                    Elements elementsP = elementSpan.select("p");
                    while (elementsP.iterator().hasNext()) {
                        Element elementP = elementsP.iterator().next();
                        moTa += elementP.text();
                        elementsP = elementsP.next();
                    }
                    HistoricalFigure historicalFigure = new HistoricalFigure(index);
                    historicalFigure.setNguonDuLieu(ConfigHtml.NGUOIKESU_URL);
                    historicalFigure.setTen(elementH3.text());
                    historicalFigure.setMoTa(moTa);
                    historicalFigures.add(historicalFigure);
                    index++;
                    System.out.println(elementH3.text());
                    System.out.println(elementA.attr("href"));
                    System.out.println(moTa);
                    System.out.println("*****************");
                } catch (Exception e) {
                    throw new HistoricalFigureDataCollectionException();
                }
                elementsLi = elementsLi.next();
            }
            startWeb += 10;
        }
        return historicalFigures;
    }

    /**
     * Thu thập dữ liệu về những người đứng đầu trong lịch sử Việt Nam
     * @param index - chỉ số bắt đầu của id
     * @return Danh sách thông tin những người đứng đầu trong lịch sử Việt Nam
     * @throws IOException
     */
    private List<Dominator> collectionDataDominator(int index) throws IOException {
        List<Dominator> dominators = new ArrayList<>();
        System.out.println("start");
        int startWeb = 0;
        while (startWeb <= 150) {
            String url = ConfigHtml.NGUOIKESU_URL + "dong-lich-su";
            if (startWeb != 0) {
                url += "?start=" + String.valueOf(startWeb);
            }
            Document document = getDocument(url);
            Element elementId = document.getElementById("content");
            Elements elementsDiv = elementId.select("div").get(1).select("div").get(2).select("div");
            while (elementsDiv.iterator().hasNext()) {
                try {
                    Element elementDiv = elementsDiv.iterator().next();
                    if (elementDiv.attr("class").equals("com-content-category-blog__item blog-item")) {
                        Element elementDivChildren = elementDiv.select("div").first();
                        String ten = elementDivChildren.select("div").first().select("a").first().text();
                        if (!ten.contains("Kỷ") && !ten.contains("Thuộc") && ten.contains("-")) {
                            try {
                                String trieuDai = elementDivChildren.select("dl").first().select("dd").first().text();
                                String moTa = "";
                                Elements elementsP = elementDivChildren.select("p");
                                while (elementsP.iterator().hasNext()) {
                                    Element elementP = elementsP.iterator().next();
                                    moTa += elementP.text();
                                    elementsP = elementsP.next();
                                }
                                Dominator dominator = new Dominator(index);
//                            List<String> relatedToHistoricalDynasties = new ArrayList<>();
//                            relatedToHistoricalDynasties.add(trieuDai);
//                            dominator.setRelatedToHistoricalDynasties(relatedToHistoricalDynasties);
                                dominator.setMoTa(moTa);
                                dominator.setNguonDuLieu(ConfigHtml.NGUOIKESU_URL);
                                dominator.setKieu(ConfigDataType.DATA_TYPE_DOMINATOR);
                                StringTokenizer stringTokenizer = new StringTokenizer(ten, "-");
                                if (stringTokenizer.countTokens() == 1) {
                                    dominator.setTen(stringTokenizer.nextToken());
                                } else {
                                    dominator.setTen(stringTokenizer.nextToken().trim());
                                    dominator.setTenHuy(stringTokenizer.nextToken().trim());
                                }
                                System.out.println(dominator.getTen());
                                dominators.add(dominator);
                                index++;
                                System.out.println("T: " + ten);
                                System.out.println("TD: " + trieuDai);
                                System.out.println("MT: " + moTa);
                                System.out.println("******************************");
                            } catch (Exception e) {
                                throw new HistoricalFigureDataCollectionException();
                            }
                        }
                    }
                } catch (Exception e) {

                }
                elementsDiv = elementsDiv.next();
            }
            startWeb += 6;
        }
        return dominators;
    }

    /**
     * Thu thập dữ liệu về các  di tích của Việt Nam
     *
     * @return Danh sách các di tích của Việt Nam
     * @throws IOException
     * @throws HistoricalSiteDataCollectionException
     */
    @Override
    public List<HistoricalSite> collectionDataHistoricalSite() throws IOException, HistoricalSiteDataCollectionException {
        List<HistoricalSite> historicalSites = new ArrayList<>();
        int index = 1;
        int startWeb = 0;
        while (startWeb <= 30) {
            String url = ConfigHtml.NGUOIKESU_URL + "di-tich-lich-su?types[0]=1";
            if (startWeb != 0) {
                url += "&start=" + String.valueOf(startWeb);
            }
            Document document = getDocument(url);
            Element elementId = document.getElementById("content");
            Element elementDiv = elementId.select("div").select("div").get(2).select("div").first();
            Element elementUl = elementDiv.select("ul").first();
            Elements elementsLi = elementUl.select("li");
            while (elementsLi.iterator().hasNext()) {
                try {
                    Element elementLi = elementsLi.iterator().next();
                    Element elementH3 = elementLi.select("h3").first();
                    Element elementSpan = elementLi.select("span").first();
                    Element elementA = elementLi.select("a").first();
                    String moTa = "";
                    String tenDiTich = "";
                    Elements elementsP = elementSpan.select("p");
                    while (elementsP.iterator().hasNext()) {
                        Element elementP = elementsP.iterator().next();
                        moTa += elementP.text();
                        elementsP = elementsP.next();
                    }
                    tenDiTich = elementH3.text();
                    System.out.println(tenDiTich);
                    System.out.println(elementA.attr("href"));
                    System.out.println(moTa);
                    System.out.println("*****************");
                    HistoricalSite historicalSite = new HistoricalSite(index);
                    historicalSite.setTen(tenDiTich);
                    historicalSite.setMoTa(moTa);
                    historicalSite.setNguonDuLieu(ConfigHtml.NGUOIKESU_URL);
                    historicalSites.add(historicalSite);
                    index++;
                } catch (Exception e) {
                    throw new HistoricalSiteDataCollectionException();
                }
                elementsLi = elementsLi.next();
            }
            startWeb += 10;
        }
        return historicalSites;
    }

    /**
     * Thu thập dữ liệu về các sự kiện lịch sử Việt Nam
     *
     * @return Danh sách các sự kiện lịch sử Việt Nam
     * @throws IOException
     * @throws HistoricEventDataCollectionException
     */
    @Override
    public List<HistoricEvent> collectionDataHistoricEvent() throws IOException {
        return null;
    }

    /**
     * Thu thập dữ liệu và lưu trữ dữ liệu
     *
     * @throws IOException
     * @throws DataCollectionException
     */
    @Override
    public void collectData() throws DataCollectionException {
        try {
            List<CulturalFestival> culturalFestivals = collectionDataCulturalFestival();
            List<HistoricalDynasty> historicalDynasties = collectionDataHistoricalDynasty();
            List<HistoricalFigure> historicalFigures = collectionDataHistoricalFigure();
            List<HistoricalSite> historicalSites = collectionDataHistoricalSite();
            List<HistoricEvent> historicEvents = collectionDataHistoricEvent();

            getRelationship(culturalFestivals, culturalFestivals, historicalDynasties, historicalFigures, historicalSites, historicEvents);
            getRelationship(historicalDynasties, culturalFestivals, historicalDynasties, historicalFigures, historicalSites, historicEvents);
            getRelationship(historicalFigures, culturalFestivals, historicalDynasties, historicalFigures, historicalSites, historicEvents);
            getRelationship(historicalSites, culturalFestivals, historicalDynasties, historicalFigures, historicalSites, historicEvents);
            getRelationship(historicEvents, culturalFestivals, historicalDynasties, historicalFigures, historicalSites, historicEvents);

            if (culturalFestivals != null) {
                IDataManipulationCulturalFestival dataManipulationCulturalFestival = new DataManipulationCulturalFestival();
                dataManipulationCulturalFestival.insertDataCulturalFestivals(ConfigResourceData.RESERVE_DATA_NGUOIKESU_PATH + NAME_FILE[0], culturalFestivals);
            }
            if (historicalDynasties != null) {
                IDataManipulationHistoricalDynasty dataManipulationHistoricalDynasty = new DataManipulationHistoricalDynasty();
                dataManipulationHistoricalDynasty.insertDataHistoricalDynasties(ConfigResourceData.RESERVE_DATA_NGUOIKESU_PATH + NAME_FILE[1], historicalDynasties);
            }
            if (historicalFigures != null) {
                IDataManipulationHistoricalFigure dataManipulationHistoricalFigure = new DataManipulationHistoricalFigure();
                dataManipulationHistoricalFigure.insertDataHistoricalFigures(ConfigResourceData.RESERVE_DATA_NGUOIKESU_PATH + NAME_FILE[2], historicalFigures);
            }
            if (historicalSites != null) {
                IDataManipulationHistoricalSite dataManipulationHistoricalSite = new DataManipulationHistoricalSite();
                dataManipulationHistoricalSite.insertDataHistoricalSites(ConfigResourceData.RESERVE_DATA_NGUOIKESU_PATH + NAME_FILE[3], historicalSites);
            }
            if (historicEvents != null) {
                IDataManipulationHistoricEvent dataManipulationHistoricEvent = new DataManipulationHistoricEvent();
                dataManipulationHistoricEvent.insertDataHistoricEvents(ConfigResourceData.RESERVE_DATA_NGUOIKESU_PATH + NAME_FILE[4], historicEvents);
            }
        } catch (Exception e) {
            throw new DataCollectionException("Collection Data error !!!!");
        }
    }
}
