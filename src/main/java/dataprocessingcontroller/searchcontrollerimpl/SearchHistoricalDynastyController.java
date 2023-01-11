package dataprocessingcontroller.searchcontrollerimpl;

import dataprocessingcontroller.SearchController;
import entity.HistoricalDynasty;
import utils.configs.ConfigAccuracy;

import java.util.ArrayList;
import java.util.List;

public class SearchHistoricalDynastyController extends SearchController {

    @Override
    public List<HistoricalDynasty> searchByKeyWord(String keyWord) {
        List<HistoricalDynasty> historicalDynasties = new ArrayList<>();
        List<HistoricalDynasty> allHistoricalDynasty = getAllHistoricalDynasty();

        for (HistoricalDynasty historicalDynasty : historicalDynasties) {
            if (getSimilarityKeyWordInString(keyWord, historicalDynasty.getTen()) >= ConfigAccuracy.ACCURACY)
                historicalDynasties.add(historicalDynasty);
        }

        return historicalDynasties;
    }
}
