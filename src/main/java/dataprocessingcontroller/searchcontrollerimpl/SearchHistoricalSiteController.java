package dataprocessingcontroller.searchcontrollerimpl;

import dataprocessingcontroller.SearchController;
import entity.HistoricalSite;
import utils.configs.ConfigAccuracy;

import java.util.ArrayList;
import java.util.List;

public class SearchHistoricalSiteController extends SearchController {

    @Override
    public List<HistoricalSite> searchByKeyWord(String keyWord) {
        List<HistoricalSite> historicalSites = new ArrayList<>();
        List<HistoricalSite> allHistoricalSite = getAllHistoricalSite();

        for (HistoricalSite historicalSite : allHistoricalSite) {
            if (getSimilarityKeyWordInString(keyWord, historicalSite.getTen()) >= ConfigAccuracy.ACCURACY)
                historicalSites.add(historicalSite);
        }

        return historicalSites;
    }
}
