package data.datamanipulation.datamanipulation;

import data.datamanipulation.IDataManipulationHistoricalSite;
import entity.HistoricalFigure;
import entity.HistoricalSite;
import org.json.simple.*;

import java.io.FileWriter;
import java.util.List;

public class DataManipulationHistoricalSite implements IDataManipulationHistoricalSite {
    @Override
    public void insertDataHistoricalSites(String url, List<HistoricalSite> historicalSites) {
        JSONArray jsonArrayHistoricalSites = new JSONArray();
        for (HistoricalSite historicalSite : historicalSites){
            jsonArrayHistoricalSites.add(historicalSite.toJSONObject());
        }
        try {
            FileWriter fileWriter = new FileWriter(url);
            fileWriter.write(jsonArrayHistoricalSites.toString());
            fileWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<HistoricalSite> getDataHistoricalSites(String url) {
        return null;
    }
}
