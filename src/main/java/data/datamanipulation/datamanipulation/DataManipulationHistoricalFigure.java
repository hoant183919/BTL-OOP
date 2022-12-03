package data.datamanipulation.datamanipulation;

import data.datamanipulation.IDataManipulationHistoricalFigure;
import entity.HistoricalFigure;
import org.json.simple.*;

import java.io.FileWriter;
import java.util.List;

public class DataManipulationHistoricalFigure implements IDataManipulationHistoricalFigure {
    @Override
    public void insertDataHistoricalFigures(String url, List<HistoricalFigure> historicalFigures) {
        JSONArray jsonArrayHistoricalFigures = new JSONArray();
        for (HistoricalFigure historicalFigure : historicalFigures){
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
        return null;
    }
}
