package main.java.data.datamanipulation;

import main.java.entity.HistoricEvent;

import java.util.List;

public interface IDataManipulationHistoricEvent {
    public void insertDataHistoricEvents(List<HistoricEvent> historicEvents);
    public List<HistoricEvent> getDataHistoricEvents();
}
