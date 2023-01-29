package datacollectioncontroller;

import common.exception.DataCollectionException;
import entity.*;
import org.jsoup.nodes.Document;
import utils.Utils;
import utils.configs.SSLHelper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static javafx.css.StyleOrigin.USER_AGENT;

public interface IDataCollectionController extends IDataCollectionCulturalFestivalController, IDataCollectionHistoricalDynastyController, IDataCollectionHistoricalFigureController, IDataCollectionHistoricalSiteController, IDataCollectionHistoricEventController {

    /**
     * Lấy document của trang web
     *
     * @param url - Đường dẫn đến trang cần thu thập document
     * @return Document của trang web đó
     * @throws IOException
     */
    public default Document getDocument(String url) throws IOException {
        return SSLHelper.getConnection(url).userAgent(String.valueOf(USER_AGENT)).get();
    }

    /**
     * Tìm mối quan hệ giữa các model trong cùng 1 trang web
     *
     * @param list - danh sách các thực thể tìm mối quan hệ
     */
    public default void getRelationship(List<?> list, List<CulturalFestival> culturalFestivalsSearch, List<HistoricalDynasty> historicalDynastiesSearch, List<HistoricalFigure> historicalFiguresSearch, List<HistoricalSite> historicalSitesSearch, List<HistoricEvent> historicEventsSearch) throws IOException {
        if (list == null) return;
        int k = 0;
        while (k < list.size()) {
            HistoricObject historicObject = (HistoricObject) list.get(k);
            System.out.println(historicObject.getTen() + " --- ");
            if (historicObject.getMoTa() != null) {
                int l = 0;
                List<CulturalFestival> culturalFestivals = culturalFestivalsSearch;
                List<String> relatedToCulturalFestivals = new ArrayList<>();
                if (culturalFestivals != null) {
                    while (l < culturalFestivals.size()) {
                        CulturalFestival culturalFestival = culturalFestivals.get(l);
                        if (!historicObject.getTen().equals(culturalFestival.getTen())) {
                            if (Utils.checkStringContainString(historicObject.getMoTa(), culturalFestival.getTen())) {
                                relatedToCulturalFestivals.add(culturalFestival.getTen());
                            }
                        }
                        l++;
                    }
                }
                historicObject.setRelatedToCulturalFestivals(relatedToCulturalFestivals);

                l = 0;

                List<HistoricalFigure> historicalFigures = historicalFiguresSearch;
                List<String> relatedToHistoricalFigures = new ArrayList<>();
                if (historicalFigures != null) {
                    while (l < historicalFigures.size()) {
                        HistoricalFigure historicalFigure = historicalFigures.get(l);
                        if (!historicObject.getTen().equals(historicalFigure.getTen())) {
                            if (Utils.checkStringContainString(historicObject.getMoTa(), historicalFigure.getTen())) {
                                relatedToHistoricalFigures.add(historicalFigure.getTen());
                            }
                        }
                        l++;
                    }
                }
                historicObject.setRelatedToHistoricalFigures(relatedToHistoricalFigures);

                l = 0;

                List<HistoricalDynasty> historicalDynasties = historicalDynastiesSearch;
                List<String> relatedToHistoricalDynasties = new ArrayList<>();
                if (historicalDynasties != null) {
                    while (l < historicalDynasties.size()) {
                        HistoricalDynasty historicalDynasty = historicalDynasties.get(l);
                        if (!historicObject.getTen().equals(historicalDynasty.getTen())) {
                            if (Utils.checkStringContainString(historicObject.getMoTa(), historicalDynasty.getTen())) {
                                relatedToHistoricalDynasties.add(historicalDynasty.getTen());
                            }
                        }
                        l++;
                    }
                }
                historicObject.setRelatedToHistoricalDynasties(relatedToHistoricalDynasties);

                l = 0;

                List<HistoricalSite> historicalSites = historicalSitesSearch;
                List<String> relatedToHistoricalSites = new ArrayList<>();
                if (historicalSites != null) {
                    while (l < historicalSites.size()) {
                        HistoricalSite historicalSite = historicalSites.get(l);
                        if (!historicObject.getTen().equals(historicalSite.getTen())) {
                            if (Utils.checkStringContainString(historicObject.getMoTa(), historicalSite.getTen())) {
                                relatedToHistoricalSites.add(historicalSite.getTen());
                            }
                        }
                        l++;
                    }
                }
                historicObject.setRelatedToHistoricalSites(relatedToHistoricalSites);

                l = 0;

                List<HistoricEvent> historicEvents = historicEventsSearch;
                List<String> relatedToHistoricEvents = new ArrayList<>();
                if (historicEvents != null) {
                    while (l < historicEvents.size()) {
                        HistoricEvent historicEvent = historicEvents.get(l);
                        if (!historicObject.getTen().equals(historicEvent.getTen())) {
                            if (Utils.checkStringContainString(historicObject.getMoTa(), historicEvent.getTen())) {
                                relatedToHistoricEvents.add(historicEvent.getTen());
                            }
                        }
                        l++;
                    }
                }
                historicObject.setRelatedToHistoricEvents(relatedToHistoricEvents);
            }
            k++;
        }
    }

    /**
     * Thu thập dữ liệu và lưu trữ dữ liệu
     * @throws IOException
     * @throws DataCollectionException
     */
    public void collectData() throws IOException, DataCollectionException;
}
