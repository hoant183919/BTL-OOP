package datamanipulation.datamanipulationimpl;

import datamanipulation.IDataManipulationHistoricEvent;
import entity.HistoricEvent;
import entity.WarEvent;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import utils.configs.ConfigDataType;
import utils.configs.ConfigResourceData;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class DataManipulationHistoricEvent implements IDataManipulationHistoricEvent {
    @Override
    public void insertDataHistoricEvents(String url, List<HistoricEvent> historicEvents) {
        JSONArray jsonArrayHistoricEvents = new JSONArray();
        for (HistoricEvent historicEvent : historicEvents) {
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
        url += ConfigResourceData.NAME_FILE[4];
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
                historicEvent.setNguonDuLieu((String) jsonObject.get("nguonDuLieu"));
                historicEvent.setKieu((String) jsonObject.get("kieu"));
                try {
                    historicEvent.setRelatedToCulturalFestivals(String.join(", ", (List<String>) jsonObject.get("leHoiLienQuan")));
                } catch (Exception e) {

                }
                try {
                    historicEvent.setRelatedToHistoricalDynasties(String.join(", ", (List<String>) jsonObject.get("trieuDaiLienQuan")));
                } catch (Exception e) {

                }
                try {
                    historicEvent.setRelatedToHistoricalFigures(String.join(", ", (List<String>) jsonObject.get("nhanVatLienQuan")));
                } catch (Exception e) {

                }
                try {
                    historicEvent.setRelatedToHistoricEvents(String.join(", ", (List<String>) jsonObject.get("suKienLienQuan")));
                } catch (Exception e) {

                }
                try {
                    historicEvent.setRelatedToHistoricalSites(String.join(", ", (List<String>) jsonObject.get("diTichLienQuan")));
                } catch (Exception e) {

                }
                String kieu = "";
                try {
                    kieu = (String) jsonObject.get("kieu");
                    if (!kieu.equals(ConfigDataType.DATA_TYPE_WAR_EVENT)) {
                        historicEvents.add(historicEvent);
                    } else {
                        WarEvent warEvent = (WarEvent) historicEvent;
                        warEvent.setThoiGian((String) jsonObject.get("thoiGian"));
                        warEvent.setThoiKy((String) jsonObject.get("thoiKy"));
                        warEvent.setLucLuong((String) jsonObject.get("lucLuong"));
                        warEvent.setDoiPhuong((String) jsonObject.get("doiPhuong"));
                        warEvent.setKetQua((String) jsonObject.get("ketQua"));
                        historicEvents.add(warEvent);
                    }
                } catch (Exception e){
                    historicEvents.add(historicEvent);
                }
                k++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return historicEvents;
    }
}
