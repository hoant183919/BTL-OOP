package data.datamanipulation.datamanipulation;

import data.datamanipulation.IDataManipulationHistoricalSite;
import entity.HistoricalFigure;
import entity.HistoricalSite;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import utils.configs.ConfigResource;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.util.ArrayList;
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
        url += ConfigResource.NAME_FILE[3];
        List<HistoricalSite> historicalSites = new ArrayList<>();
        JSONParser parser = new JSONParser();
        try {
            Reader reader = new FileReader(url);
            JSONArray jsonArray = (JSONArray) parser.parse(reader);
            int k = 0;
            while (k < jsonArray.size()) {
                JSONObject jsonObject = (JSONObject) jsonArray.get(k);
                HistoricalSite historicalSite = new HistoricalSite(Integer.parseInt(String.valueOf(jsonObject.get("id"))));
                historicalSite.setMoTa((String) jsonObject.get("moTa"));
                historicalSite.setTen((String) jsonObject.get("ten"));
                historicalSites.add(historicalSite);
                k++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return historicalSites;
    }
}
