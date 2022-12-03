package entity;

import org.json.simple.JSONObject;

import java.util.List;

public class HistoricalDynasty extends BaseEntity{
    public HistoricalDynasty(int id) {
        super(id);
    }
    private String tenTrieuDai;
    private String thoiGianBatDau;
    private String thoiGianKetThuc;

    public String getTenTrieuDai() {
        return tenTrieuDai;
    }

    public String getKinhDo() {
        return kinhDo;
    }

    private String thoiKy;
    private String kinhDo;

    public void setTenTrieuDai(String tenTrieuDai) {
        this.tenTrieuDai = tenTrieuDai;
    }

    public void setKinhDo(String kinhDo) {
        this.kinhDo = kinhDo;
    }

    private List<Dominator> danhSachNguoiDungDau;
    private String moTa;

    @Override
    public JSONObject toJSONObject(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", getId());
        jsonObject.put("tenTrieuDai", getTenTrieuDai());
        jsonObject.put("kinhDo", getKinhDo());
        return jsonObject;
    }
}
