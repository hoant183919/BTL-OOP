package data.datamanipulation;

import entity.BaseEntity;
import entity.HistoricEvent;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import utils.configs.ConfigResource;

import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public interface IDataManipulation {
    public default List<BaseEntity> getData(String url, int index){
        url += ConfigResource.NAME_FILE[index];
        List<BaseEntity> baseEntities = new ArrayList<>();
        JSONParser parser = new JSONParser();
        try {
            Reader reader = new FileReader(url);
            JSONArray jsonArray = (JSONArray) parser.parse(reader);
            int k = 0;
            while (k < jsonArray.size()) {
                JSONObject jsonObject = (JSONObject) jsonArray.get(k);
                BaseEntity baseEntity = new HistoricEvent(Integer.parseInt(String.valueOf(jsonObject.get("id"))));
                baseEntity.setMoTa((String) jsonObject.get("moTa"));
                baseEntity.setTen((String) jsonObject.get("ten"));
                baseEntities.add(baseEntity);
                k++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return baseEntities;
    }
}
