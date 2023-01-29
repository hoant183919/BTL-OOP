package datamanipulation.datamanipulationimpl;

import datamanipulation.IDataManipulationHistoricalFigure;
import entity.HistoricalFigure;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import utils.configs.ConfigResourceData;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class DataManipulationHistoricalFigure implements IDataManipulationHistoricalFigure {
    @Override
    public void insertDataHistoricalFigures(String url, List<HistoricalFigure> historicalFigures) {
        JSONArray jsonArrayHistoricalFigures = new JSONArray();
        for (HistoricalFigure historicalFigure : historicalFigures) {
            jsonArrayHistoricalFigures.add(historicalFigure.toJSONObject());
        }
        try {
            FileWriter fileWriter = new FileWriter(url);
            fileWriter.write(jsonArrayHistoricalFigures.toString());
            fileWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<HistoricalFigure> getDataHistoricalFigures(String url) {
        url += ConfigResourceData.NAME_FILE[2];
        List<HistoricalFigure> historicalFigures = new ArrayList<>();
        JSONParser parser = new JSONParser();
        try {
            Reader reader = new FileReader(url);
            JSONArray jsonArray = (JSONArray) parser.parse(reader);
            int k = 0;
            while (k < jsonArray.size()) {
                JSONObject jsonObject = (JSONObject) jsonArray.get(k);
                HistoricalFigure historicalFigure = new HistoricalFigure(Integer.parseInt(String.valueOf(jsonObject.get("id"))));
                historicalFigure.setMoTa((String) jsonObject.get("moTa"));
                historicalFigure.setTen((String) jsonObject.get("ten"));

                historicalFigures.add(historicalFigure);
                k++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return historicalFigures;
    }
}
