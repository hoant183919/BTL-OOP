package data.datamanipulation.datamanipulation;

import data.datamanipulation.IDataManipulationHistoricalDynasty;
import entity.HistoricalDynasty;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import utils.configs.ConfigResourceData;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class DataManipulationHistoricalDynasty implements IDataManipulationHistoricalDynasty {
    @Override
    public void insertDataHistoricalDynasties(String url, List<HistoricalDynasty> historicalDynasties) {
        JSONArray jsonArrayHistoricalDynasties = new JSONArray();
        for (HistoricalDynasty historicalDynasty : historicalDynasties) {
            System.out.println(historicalDynasty.getTen() + " " + historicalDynasty.getKinhDo());
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
        url += ConfigResourceData.NAME_FILE[1];
        List<HistoricalDynasty> historicalDynasties = new ArrayList<>();
        JSONParser parser = new JSONParser();
        try {
            Reader reader = new FileReader(url);
            JSONArray jsonArray = (JSONArray) parser.parse(reader);
            int k = 0;
            while (k < jsonArray.size()) {
                try {
                    JSONObject jsonObject = (JSONObject) jsonArray.get(k);
                    HistoricalDynasty historicalDynasty = new HistoricalDynasty(Integer.parseInt(String.valueOf(jsonObject.get("id"))));
                    historicalDynasty.setMoTa((String) jsonObject.get("moTa"));
                    historicalDynasty.setTen((String) jsonObject.get("ten"));
                    historicalDynasty.setKinhDo((String) jsonObject.get("kinhDo"));
                    historicalDynasty.setThoiKy((String) jsonObject.get("thoiKy"));
                    historicalDynasty.setThoiGianBatDau((String) jsonObject.get("thoiGianBatDau"));
                    historicalDynasty.setThoiGianKetThuc((String) jsonObject.get("thoiGianKetThuc"));
                    historicalDynasties.add(historicalDynasty);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                k++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return historicalDynasties;
    }
}
