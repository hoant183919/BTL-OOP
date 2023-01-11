package data.datamanipulation.datamanipulation;

import data.datamanipulation.IDataManipulationHistoricEvent;
import entity.HistoricEvent;
import entity.HistoricalFigure;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import utils.configs.ConfigResource;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.util.ArrayList;
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
        url += ConfigResource.NAME_FILE[4];
        List<HistoricEvent> historicEvents = new ArrayList<>();
        JSONParser parser = new JSONParser();
        try {
            Reader reader = new FileReader(url);
            JSONArray jsonArray = (JSONArray) parser.parse(reader);
            int k = 0;
            while (k < jsonArray.size()) {
                JSONObject jsonObject = (JSONObject) jsonArray.get(k);
                HistoricEvent historicEvent = new HistoricEvent(Integer.parseInt(String.valueOf(jsonObject.get("id"))));
                historicEvent.setMoTa((String) jsonObject.get("moTa"));
                historicEvent.setTen((String) jsonObject.get("ten"));
                historicEvents.add(historicEvent);
                k++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return historicEvents;
    }
}
