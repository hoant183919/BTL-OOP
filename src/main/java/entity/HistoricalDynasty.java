package entity;

import org.json.simple.JSONObject;

import java.util.List;

public class HistoricalDynasty extends HistoricObject{
    public HistoricalDynasty(int id) {
        super(id);
    }
    private String thoiGianBatDau; // startTime
    private String thoiGianKetThuc; // endTime
    private String thoiKy; // period
    private String kinhDo; // capital

    public String getKinhDo() {
        return kinhDo;
    }

    public void setKinhDo(String kinhDo) {
        this.kinhDo = kinhDo;
    }

    public String getThoiGianBatDau() {
        return thoiGianBatDau;
    }

    public void setThoiGianBatDau(String thoiGianBatDau) {
        this.thoiGianBatDau = thoiGianBatDau;
    }

    public String getThoiGianKetThuc() {
        return thoiGianKetThuc;
    }

    public void setThoiGianKetThuc(String thoiGianKetThuc) {
        this.thoiGianKetThuc = thoiGianKetThuc;
    }

    public String getThoiKy() {
        return thoiKy;
    }

    public void setThoiKy(String thoiKy) {
        this.thoiKy = thoiKy;
    }

    @Override
    public JSONObject toJSONObject(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", getId());
        jsonObject.put("ten", getTen());
        jsonObject.put("kinhDo", getKinhDo());
        jsonObject.put("moTa", getMoTa());
        jsonObject.put("nguonDuLieu", getNguonDuLieu());
        jsonObject.put("leHoiLienQuan", getRelatedToCulturalFestivals());
        jsonObject.put("trieuDaiLienQuan", getRelatedToHistoricalDynasties());
        jsonObject.put("nhanVatLienQuan", getRelatedToHistoricalFigures());
        jsonObject.put("diTichLienQuan", getRelatedToHistoricalSites());
        jsonObject.put("suKienLienQuan", getRelatedToHistoricEvents());
        return jsonObject;
    }
}
