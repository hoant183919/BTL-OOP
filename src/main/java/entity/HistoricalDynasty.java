package entity;

import org.json.simple.JSONObject;

import java.util.List;

public class HistoricalDynasty extends BaseEntity{
    public HistoricalDynasty(int id) {
        super(id);
    }
    private String tenTrieuDai; // dynastyName;
    private String thoiGianBatDau; // startTime
    private String thoiGianKetThuc; // endTime
    private String thoiKy; // period
    private String kinhDo; // capital
    private String moTa; // description

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getTenTrieuDai() {
        return tenTrieuDai;
    }

    public String getKinhDo() {
        return kinhDo;
    }

    public void setTenTrieuDai(String tenTrieuDai) {
        this.tenTrieuDai = tenTrieuDai;
    }

    public void setKinhDo(String kinhDo) {
        this.kinhDo = kinhDo;
    }

    private List<Dominator> danhSachNguoiDungDau;

    @Override
    public JSONObject toJSONObject(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", getId());
        jsonObject.put("tenTrieuDai", getTenTrieuDai());
        jsonObject.put("kinhDo", getKinhDo());
        jsonObject.put("moTa", getMoTa());
        return jsonObject;
    }
}
