package entity;

import org.json.simple.JSONObject;

import java.util.List;

public class CulturalFestival extends HistoricObject{
    public CulturalFestival(int id) {
        super(id);
    }
    private String thoiDiemToChucLanDau; // timeFirstOrganize
    private String diaDiem; // location
    private String thoiGian; // time
    private String ghiChu; // note

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getThoiDiemToChucLanDau() {
        return thoiDiemToChucLanDau;
    }

    public void setThoiDiemToChucLanDau(String thoiDiemToChucLanDau) {
        this.thoiDiemToChucLanDau = thoiDiemToChucLanDau;
    }

    public String getDiaDiem() {
        return diaDiem;
    }

    public void setDiaDiem(String diaDiem) {
        this.diaDiem = diaDiem;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }

    @Override
    public JSONObject toJSONObject(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", getId());
        jsonObject.put("ten", getTen());
        jsonObject.put("thoiGian", getThoiGian());
        jsonObject.put("diaDiem", getDiaDiem());
        jsonObject.put("thoiDiemToChucLanDau", getThoiDiemToChucLanDau());
        jsonObject.put("moTa", getMoTa());
        jsonObject.put("ghiChu", getGhiChu());
        jsonObject.put("nguonDuLieu", getNguonDuLieu());
        jsonObject.put("leHoiLienQuan", getRelatedToCulturalFestivals());
        jsonObject.put("trieuDaiLienQuan", getRelatedToHistoricalDynasties());
        jsonObject.put("nhanVatLienQuan", getRelatedToHistoricalFigures());
        jsonObject.put("diTichLienQuan", getRelatedToHistoricalSites());
        jsonObject.put("suKienLienQuan", getRelatedToHistoricEvents());
        return jsonObject;
    }
}
