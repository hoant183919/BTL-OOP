package views.datasummaryscene;
import org.json.JSONArray;
import org.json.JSONObject;
import views.searchscene.SearchSceneController;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

// "D:\\BTL-OOP\\src\\main\\java\\data\\reservedata\\wikipedia\\historicaldynasties.json"
public class ConvertData {

    public String historicalDynastyDataSummary(String filePath) throws Exception {
        String historicalDynastyResult = "";
        String str = new String(Files.readAllBytes(Paths.get(filePath)));
        JSONArray array = new JSONArray(str);
        for (int i = 0; i < array.length(); i++) {
            JSONObject object = array.getJSONObject(i);
            historicalDynastyResult += "ID: " + object.get("id") + "\nTên triều đại: " + object.get("tenTrieuDai") + "\nKinh đô: " + object.get("kinhDo") + "\nMô tả: " + object.get("moTa") + "\n\n";
        }
        return historicalDynastyResult;
    }
    public String culturalFestivalDataSummary(String filePath) throws Exception {
        String culturalFestivalResult = "";

        String str = new String(Files.readAllBytes(Paths.get(filePath)));
        JSONArray array = new JSONArray(str);
        for (int i = 0; i < array.length(); i++) {
            JSONObject object = array.getJSONObject(i);
            culturalFestivalResult += "ID: " + object.get("id") +  "\nTên: " + object.get("ten") + "\nThời gian: " + object.get("thoiGian") + "\nĐịa điểm: " + object.get("diaDiem")  + "\nThời điểm tổ chức lần đầu" + object.get("thoiDiemToChucLanDau" + "") + "\nMô tả: " + object.get("moTa") + "\nGhi chú: " + object.get("ghiChu") + "\n\n";
        }
        return culturalFestivalResult;
    }
    public String dominatorDataSummary(String filePath) throws Exception {
        String dominatorResult = "";
        String str = new String(Files.readAllBytes(Paths.get(filePath)));
        JSONArray array = new JSONArray(str);
        for (int i = 0; i < array.length(); i++) {
            JSONObject object = array.getJSONObject(i);
            dominatorResult += "ID: " + object.get("id") +  "\nTên: " + object.get("ten") + "\nTên chữ Hán: " +object.get("tenChuHan") + "\nVai trò: " + object.get("vaiTro") + "\nMiếu hiệu: " + object.get("mieuHieu") + "\nThụy hiệu: " + object.get("thuyHieu") + "\nNiên hiệu: " + object.get("nienHieu") + "\nTên húy: " + object.get("tenHuy") + "\nThế thứ: " + object.get("theThu") + "\nTrị vì: " + object.get("triVi") + "\nNăm sinh mất: " + object.get("namSinhMat") + "\nMô tả: " + object.get("moTa") + "\n\n";
        }
        return dominatorResult;
    }
    public String historicalSiteDataSummary(String filePath) throws Exception {
        String historicalSiteResult = "";
        String str = new String(Files.readAllBytes(Paths.get(filePath)));
        JSONArray array = new JSONArray(str);
        for (int i = 0; i < array.length(); i++) {
            JSONObject object = array.getJSONObject(i);
            historicalSiteResult += "ID: " + object.get("id") + "\nTên: " + object.get("ten") + "\nĐịa điểm: " + object.get("diaDiem") + "\nNăm công nhận" + object.get("namCN") + "\nGhi chú: " + object.get("ghiChu") + "\nMô tả: " + object.get("moTa") + "\nMiêu tả: " + object.get("mieuTa") + "\n\n";
        }
        return historicalSiteResult;
    }
    public String warEventDataSummary(String filePath) throws Exception {
        String warEventResult = "";
        String str = new String(Files.readAllBytes(Paths.get(filePath)));
        JSONArray array = new JSONArray(str);
        for (int i = 0; i < array.length(); i++) {
            JSONObject object = array.getJSONObject(i);
            warEventResult += "ID: " + object.get("id") + "\nTên sự kiện: " + object.get("tenSuKien") + "\nThời gian: " + object.get("thoiGian") + "\nThời kỳ: " + object.get("thoiKy") + "\nLực lượng: " + object.get("lucLuong") + "\nĐối phương: " + object.get("doiPhuong") + "\nMô tả: " + object.get("moTa") + "\nKết quả: " + object.get("ketQua") + "\n\n";
        }
        return warEventResult;
    }




//    public String dataHistoricalDynastySummary(String[] filePaths) throws Exception {
//        for(String filePath: filePaths) {
//            String str = new String(Files.readAllBytes(Paths.get(filePath)));
//
//           JSONArray historicalDynastyArray = new JSONArray(str);
//            historicalDynastiesArray.add(historicalDynastyArray);
//            for (int i = 0; i < historicalDynastyArray.length(); i++) {
//                JSONObject object = historicalDynastyArray.getJSONObject(i);
//                result += "ID: " + object.get("id") + "\nTen trieu dai: " + object.get("tenTrieuDai") + "\nKinh do: " + object.get("kinhDo") + "\nMo ta: " + object.get("moTa") + "\n";
//            }
//        }
//        return result;
//    }

    
}

