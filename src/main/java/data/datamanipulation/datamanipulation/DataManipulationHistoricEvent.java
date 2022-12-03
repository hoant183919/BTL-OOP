package data.datamanipulation.datamanipulation;

import data.datamanipulation.IDataManipulationHistoricEvent;
import entity.HistoricEvent;
import org.json.simple.*;

import java.io.FileWriter;
import java.util.List;

public class DataManipulationHistoricEvent implements IDataManipulationHistoricEvent {
    @Override
    public void insertDataHistoricEvents(String url, List<HistoricEvent> historicEvents) {
        JSONArray jsonArrayHistoricEvents = new JSONArray();
        for (HistoricEvent historicEvent : historicEvents){
            jsonArrayHistoricEvents.add(historicEvent.toJSONObject());
        }
        try {
            FileWriter fileWriter = new FileWriter(url);
            fileWriter.write(jsonArrayHistoricEvents.toString());
            fileWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<HistoricEvent> getDataHistoricEvents(String url) {
        return null;
    }
}
