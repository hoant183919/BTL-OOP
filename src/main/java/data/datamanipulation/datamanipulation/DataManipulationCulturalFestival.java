package data.datamanipulation.datamanipulation;

import data.datamanipulation.IDataManipulationCulturalFestival;
import entity.CulturalFestival;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import utils.configs.ConfigResource;

import java.io.*;
import java.util.ArrayList;
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
        url += ConfigResource.NAME_FILE[0];
        List<CulturalFestival> culturalFestivals = new ArrayList<>();
        JSONParser parser = new JSONParser();
        try {
            Reader reader = new FileReader(url);
            JSONArray jsonArray = (JSONArray) parser.parse(reader);
            int k = 0;
            while (k < jsonArray.size()) {
                JSONObject jsonObject = (JSONObject) jsonArray.get(k);
                CulturalFestival culturalFestival = new CulturalFestival(Integer.parseInt(String.valueOf(jsonObject.get("id"))));
                culturalFestival.setMoTa((String) jsonObject.get("moTa"));
                culturalFestival.setTen((String) jsonObject.get("ten"));
                culturalFestivals.add(culturalFestival);
                k++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return culturalFestivals;
    }
}
