package datamanipulation.datamanipulationimpl;

import datamanipulation.IDataManipulationHistoricalSite;
import entity.HistoricalSite;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import utils.configs.ConfigResourceData;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class DataManipulationHistoricalSite implements IDataManipulationHistoricalSite {
    @Override
    public void insertDataHistoricalSites(String url, List<HistoricalSite> historicalSites) {
        JSONArray jsonArrayHistoricalSites = new JSONArray();
        for (HistoricalSite historicalSite : historicalSites) {
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
        url += ConfigResourceData.NAME_FILE[3];
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
                historicalSite.setDiaDiem((String) jsonObject.get("diaDiem"));
                historicalSite.setNamCN((String) jsonObject.get("namCN"));
                historicalSite.setLoaiDiTich((String) jsonObject.get("loaiDiTich"));
                historicalSite.setMieuTa((String) jsonObject.get("mieuTa"));
                historicalSite.setGhiChu((String) jsonObject.get("ghiChu"));
                historicalSite.setNguonDuLieu((String) jsonObject.get("nguonDuLieu"));
                try {
                    historicalSite.setRelatedToCulturalFestivals(String.join(", ", (List<String>) jsonObject.get("leHoiLienQuan")));
                } catch (Exception e){

                }
                try {
                    historicalSite.setRelatedToHistoricalDynasties(String.join(", ", (List<String>) jsonObject.get("trieuDaiLienQuan")));
                } catch (Exception e){

                }
                try {
                    historicalSite.setRelatedToHistoricalFigures(String.join(", ", (List<String>) jsonObject.get("nhanVatLienQuan")));
                } catch (Exception e){

                }
                try {
                    historicalSite.setRelatedToHistoricEvents(String.join(", ", (List<String>) jsonObject.get("suKienLienQuan")));
                } catch (Exception e){

                }
                try {
                    historicalSite.setRelatedToHistoricalSites(String.join(", ", (List<String>) jsonObject.get("diTichLienQuan")));
                } catch (Exception e){

                }
                historicalSites.add(historicalSite);
                k++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return historicalSites;
    }
}
