package dataprocessingcontroller.searchcontrollerimpl;

import dataprocessingcontroller.SearchController;
import entity.HistoricalFigure;
import utils.configs.ConfigAccuracy;

import java.util.ArrayList;
import java.util.List;

public class SearchHistoricalFigureController extends SearchController {

    @Override
    public List<HistoricalFigure> searchByKeyWord(String keyWord) {
        List<HistoricalFigure> historicalFigures = new ArrayList<>();
        List<HistoricalFigure> allHistoricalFigure = getAllHistoricalFigure();

        for (HistoricalFigure historicalFigure : allHistoricalFigure) {
            if (getSimilarityKeyWordInString(keyWord, historicalFigure.getTen()) >= ConfigAccuracy.ACCURACY)
                historicalFigures.add(historicalFigure);

        }

        return historicalFigures;
    }
}
