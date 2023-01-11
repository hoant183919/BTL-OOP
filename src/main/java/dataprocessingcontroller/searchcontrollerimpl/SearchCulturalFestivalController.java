package dataprocessingcontroller.searchcontrollerimpl;

import dataprocessingcontroller.SearchController;
import entity.CulturalFestival;
import utils.configs.ConfigAccuracy;

import java.util.ArrayList;
import java.util.List;

public class SearchCulturalFestivalController extends SearchController {

    @Override
    public List<CulturalFestival> searchByKeyWord(String keyWord) {
        List<CulturalFestival> culturalFestivals = new ArrayList<>();
        List<CulturalFestival> allCulturalFestival = getAllCulturalFestival();

        for (CulturalFestival culturalFestival : allCulturalFestival) {
            if (getSimilarityKeyWordInString(keyWord, culturalFestival.getTen()) >= ConfigAccuracy.ACCURACY)
                culturalFestivals.add(culturalFestival);
        }

        return culturalFestivals;
    }
}
