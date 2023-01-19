package data.datamanipulation;

import entity.BaseEntity;
import entity.HistoricEvent;
import entity.HistoricObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import utils.configs.ConfigResourceData;

import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public interface IDataManipulation {
    public default List<BaseEntity> getData(String url, int index){
        url += ConfigResourceData.NAME_FILE[index];
        List<BaseEntity> baseEntities = new ArrayList<>();
        JSONParser parser = new JSONParser();
        try {
            Reader reader = new FileReader(url);
            JSONArray jsonArray = (JSONArray) parser.parse(reader);
            int k = 0;
            while (k < jsonArray.size()) {
                JSONObject jsonObject = (JSONObject) jsonArray.get(k);
                HistoricObject historicObject = new HistoricEvent(Integer.parseInt(String.valueOf(jsonObject.get("id"))));
                historicObject.setMoTa((String) jsonObject.get("moTa"));
                historicObject.setTen((String) jsonObject.get("ten"));
                baseEntities.add(historicObject);
                k++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return baseEntities;
    }
}
