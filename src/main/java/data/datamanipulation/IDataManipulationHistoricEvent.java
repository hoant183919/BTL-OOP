package data.datamanipulation;

import entity.HistoricEvent;

import java.util.List;

public interface IDataManipulationHistoricEvent extends IDataManipulation{
    public void insertDataHistoricEvents(String url, List<HistoricEvent> historicEvents);
    public List<HistoricEvent> getDataHistoricEvents(String url);
}
