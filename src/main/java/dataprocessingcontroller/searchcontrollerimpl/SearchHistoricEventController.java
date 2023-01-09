package dataprocessingcontroller.searchcontrollerimpl;

import dataprocessingcontroller.SearchController;
import entity.HistoricEvent;
import utils.configs.ConfigAccuracy;

import java.util.ArrayList;
import java.util.List;

public class SearchHistoricEventController extends SearchController {

    @Override
    public List<HistoricEvent> searchByKeyWord(String keyWord) {
        List<HistoricEvent> historicEvents = new ArrayList<>();
        List<HistoricEvent> allHistoricEvent = getAllHistoricEvent();

        for (HistoricEvent historicEvent : allHistoricEvent) {
            if (getSimilarityKeyWordInString(keyWord, historicEvent.getTen()) >= ConfigAccuracy.ACCURACY)
                historicEvents.add(historicEvent);
        }

        return historicEvents;
    }
}
