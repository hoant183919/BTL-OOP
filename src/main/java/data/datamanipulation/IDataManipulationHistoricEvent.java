package data.datamanipulation;

import entity.HistoricEvent;

import java.util.List;

public interface IDataManipulationHistoricEvent {
    public void insertDataHistoricEvents(String url, List<HistoricEvent> historicEvents);
    public List<HistoricEvent> getDataHistoricEvents(String url);
}
