package datamanipulation.datamanipulationimpl;

import datamanipulation.IDataManipulationHistoricalFigure;
import entity.Dominator;
import entity.HistoricalFigure;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import utils.configs.ConfigDataType;
import utils.configs.ConfigResourceData;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class DataManipulationHistoricalFigure implements IDataManipulationHistoricalFigure {
    @Override
    public void insertDataHistoricalFigures(String url, List<HistoricalFigure> historicalFigures) {
        JSONArray jsonArrayHistoricalFigures = new JSONArray();
        for (HistoricalFigure historicalFigure : historicalFigures) {
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
        url += ConfigResourceData.NAME_FILE[2];
        List<HistoricalFigure> historicalFigures = new ArrayList<>();
        JSONParser parser = new JSONParser();
        try {
            Reader reader = new FileReader(url);
            JSONArray jsonArray = (JSONArray) parser.parse(reader);
            int k = 0;
            while (k < jsonArray.size()) {
                JSONObject jsonObject = (JSONObject) jsonArray.get(k);
                try {
                    HistoricalFigure historicalFigure = new HistoricalFigure(Integer.parseInt(String.valueOf(jsonObject.get("id"))));
                    historicalFigure.setMoTa((String) jsonObject.get("moTa"));
                    historicalFigure.setTen((String) jsonObject.get("ten"));
                    historicalFigure.setNguonDuLieu((String) jsonObject.get("nguonDuLieu"));
                    historicalFigure.setKieu((String) jsonObject.get("kieu"));
                    historicalFigure.setVaiTro((String) jsonObject.get("vaiTro"));
                    historicalFigure.setMieuHieu((String) jsonObject.get("mieuHieu"));
                    historicalFigure.setThuyHieu((String) jsonObject.get("thuyHieu"));
                    historicalFigure.setNienHieu((String) jsonObject.get("nienHieu"));
                    historicalFigure.setTenHuy((String) jsonObject.get("tenHuy"));
                    historicalFigure.setTheThu((String) jsonObject.get("theThu"));
                    historicalFigure.setTriVi((String) jsonObject.get("triVi"));
                    historicalFigure.setTenChuHan((String) jsonObject.get("tenChuHan"));
                    historicalFigure.setNamSinhMat((String) jsonObject.get("namSinhMat"));
                    historicalFigure.setRelatedToCulturalFestivals((String) jsonObject.get("leHoiLienQuan"));
                    historicalFigure.setRelatedToHistoricalDynasties((String) jsonObject.get("trieuDaiLienQuan"));
                    historicalFigure.setRelatedToHistoricalFigures((String) jsonObject.get("nhanVatLienQuan"));
                    historicalFigure.setRelatedToHistoricEvents((String) jsonObject.get("suKienLienQuan"));
                    historicalFigure.setRelatedToHistoricalSites((String) jsonObject.get("diTichLienQuan"));
                    historicalFigures.add(historicalFigure);
                } catch (Exception e) {

                }
                k++;



//                String kieu = "";
//                try {
//                    kieu = (String) jsonObject.get("kieu");
//                    if (!kieu.equals(ConfigDataType.DATA_TYPE_DOMINATOR)) {
//                        historicalFigures.add(historicalFigure);
//                    } else {
//                        Dominator dominator = (Dominator) historicalFigure;
//                        dominator.setKieu(kieu);
//                        dominator.setVaiTro((String) jsonObject.get("vaiTro"));
//                        dominator.setMieuHieu((String) jsonObject.get("mieuHieu"));
//                        dominator.setThuyHieu((String) jsonObject.get("thuyHieu"));
//                        dominator.setNienHieu((String) jsonObject.get("nienHieu"));
//                        dominator.setTenHuy((String) jsonObject.get("tenHuy"));
//                        dominator.setTheThu((String) jsonObject.get("theThu"));
//                        dominator.setTriVi((String) jsonObject.get("triVi"));
//                        dominator.setTenChuHan((String) jsonObject.get("tenChuHan"));
//                        dominator.setNamSinhMat((String) jsonObject.get("namSinhMat"));
//                        historicalFigures.add(dominator);
//                    }
//                } catch (Exception e) {
//                    historicalFigures.add(historicalFigure);
//                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return historicalFigures;
    }
}
