package views.datasummaryscene;

import entity.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DataSummary {

    public ObservableList<HistoricalDynasty> historicalDynastyDataSummary(String[] filePaths) throws IOException {
        List<HistoricalDynasty> objectList = new ArrayList<>();
        for (String filePath : filePaths) {
            String dataSummary = new String(Files.readAllBytes(Paths.get(filePath)));
            JSONArray array = new JSONArray(dataSummary);
            for (int i = 0; i < array.length(); i++) {
                JSONObject object = array.getJSONObject(i);
                HistoricalDynasty historicalDynasty = new HistoricalDynasty(i);
                historicalDynasty.setTen(object.getString("ten"));
                historicalDynasty.setKinhDo(object.getString("kinhDo"));
                historicalDynasty.setMoTa(object.getString("moTa"));
                objectList.add(historicalDynasty);
            }
        }
        ObservableList<HistoricalDynasty> observableList = FXCollections.observableList(objectList);
        return observableList;
    }

    public ObservableList<CulturalFestival> culturalFestivalDataSummary(String[] filePaths) throws IOException {
        List<CulturalFestival> objectList = new ArrayList<>();
        for (String filePath : filePaths) {
            String dataSummary = new String(Files.readAllBytes(Paths.get(filePath)));
            JSONArray array = new JSONArray(dataSummary);
            for (int i = 0; i < array.length(); i++) {
                JSONObject object = array.getJSONObject(i);
                CulturalFestival culturalFestival = new CulturalFestival(i);
                culturalFestival.setTen(object.getString("ten"));
                culturalFestival.setDiaDiem(object.getString("diaDiem"));
                culturalFestival.setThoiGian(object.getString("thoiGian"));
                culturalFestival.setThoiDiemToChucLanDau(object.getString("thoiDiemToChucLanDau"));
                culturalFestival.setMoTa(object.get("moTa").toString());
                objectList.add(culturalFestival);
            }
        }
        ObservableList<CulturalFestival> observableList = FXCollections.observableList(objectList);
        return observableList;
    }

    public ObservableList<Dominator> historicalFigureDataSummary(String[] filePaths) throws IOException {
        List<Dominator> objectList = new ArrayList<>();
        for (String filePath : filePaths) {
            String dataSummary = new String(Files.readAllBytes(Paths.get(filePath)));
            JSONArray array = new JSONArray(dataSummary);
            for (int i = 0; i < array.length(); i++) {
                JSONObject object = array.getJSONObject(i);
                Dominator dominator = new Dominator(i);
                dominator.setTen(object.getString("ten"));
                dominator.setMieuHieu(object.getString("mieuHieu"));
                dominator.setNamSinhMat(object.get("namSinhMat").toString());
                dominator.setNienHieu(object.getString("nienHieu"));
                dominator.setTenHuy(object.getString("tenHuy"));
                dominator.setTheThu(object.getString("theThu"));
                dominator.setTenChuHan(object.get("tenChuHan").toString());
                dominator.setThuyHieu(object.getString("thuyHieu"));
                dominator.setVaiTro(object.getString("vaiTro"));
                dominator.setTriVi(object.getString("triVi"));
                objectList.add(dominator);
            }
        }
        ObservableList<Dominator> observableList = FXCollections.observableList(objectList);
        return observableList;
    }

    public ObservableList<HistoricalSite> historicalSiteDataSummary(String[] filePaths) throws IOException {
        List<HistoricalSite> objectList = new ArrayList<>();
        for (String filePath : filePaths) {
            String dataSummary = new String(Files.readAllBytes(Paths.get(filePath)));
            JSONArray array = new JSONArray(dataSummary);
            for (int i = 0; i < array.length(); i++) {
                JSONObject object = array.getJSONObject(i);
                HistoricalSite historicalSite = new HistoricalSite(i);
                historicalSite.setTen(object.getString("ten"));
                historicalSite.setDiaDiem(object.getString("diaDiem"));
                historicalSite.setNamCN(object.get("namCN").toString());
                historicalSite.setGhiChu(object.get("ghiChu").toString());
                historicalSite.setMieuTa(object.getString("mieuTa"));
                objectList.add(historicalSite);
            }
        }
        ObservableList<HistoricalSite> observableList = FXCollections.observableList(objectList);
        return observableList;
    }

    public ObservableList<WarEvent> historicEventDataSummary(String[] filePaths) throws IOException {
        List<WarEvent> objectList = new ArrayList<>();
        for (String filePath : filePaths) {
            String dataSummary = new String(Files.readAllBytes(Paths.get(filePath)));
            JSONArray array = new JSONArray(dataSummary);
            for (int i = 0; i < array.length(); i++) {
                JSONObject object = array.getJSONObject(i);
                WarEvent warEvent = new WarEvent(i);
                warEvent.setTen(object.getString("ten"));
                warEvent.setThoiGian(object.getString("thoiGian"));
                warEvent.setThoiKy(object.getString("thoiKy"));
                warEvent.setLucLuong(object.getString("lucLuong"));
                warEvent.setDoiPhuong(object.getString("doiPhuong"));
                warEvent.setKetQua(object.getString("ketQua"));
                objectList.add(warEvent);
            }
        }
        ObservableList<WarEvent> observableList = FXCollections.observableList(objectList);
        return observableList;
    }






}
