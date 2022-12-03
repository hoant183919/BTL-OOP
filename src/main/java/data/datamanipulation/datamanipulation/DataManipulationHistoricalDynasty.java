package data.datamanipulation.datamanipulation;

import data.datamanipulation.IDataManipulationHistoricalDynasty;
import entity.CulturalFestival;
import entity.HistoricalDynasty;
import org.json.simple.*;

import java.io.FileWriter;
import java.util.List;

public class DataManipulationHistoricalDynasty implements IDataManipulationHistoricalDynasty {
    @Override
    public void insertDataHistoricalDynasties(String url, List<HistoricalDynasty> historicalDynasties) {
        JSONArray jsonArrayHistoricalDynasties = new JSONArray();
        for (HistoricalDynasty historicalDynasty : historicalDynasties){
            System.out.println(historicalDynasty.getTenTrieuDai() + " " + historicalDynasty.getKinhDo());
            jsonArrayHistoricalDynasties.add(historicalDynasty.toJSONObject());
        }
        try {
            FileWriter fileWriter = new FileWriter(url);
            fileWriter.write(jsonArrayHistoricalDynasties.toString());
            fileWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<HistoricalDynasty> getDataHistoricalDynasties(String url) {
        return null;
    }
}
