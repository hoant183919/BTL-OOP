package data.datamanipulation.datamanipulation;

import data.datamanipulation.IDataManipulationCulturalFestival;
import entity.CulturalFestival;

import org.json.simple.*;

import java.io.FileWriter;
import java.util.List;

public class DataManipulationCulturalFestival implements IDataManipulationCulturalFestival {
    @Override
    public void insertDataCulturalFestivals(String url, List<CulturalFestival> culturalFestivals) {
        JSONArray jsonArrayCulturalFestivals = new JSONArray();
        for (CulturalFestival culturalFestival : culturalFestivals){
            jsonArrayCulturalFestivals.add(culturalFestival.toJSONObject());
        }
        try {
            FileWriter fileWriter = new FileWriter(url);
            fileWriter.write(jsonArrayCulturalFestivals.toString());
            fileWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<CulturalFestival> getDataCulturalFestivals(String url) {
        return null;
    }
}
