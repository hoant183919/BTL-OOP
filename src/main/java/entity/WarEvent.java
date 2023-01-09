package entity;

import org.json.simple.JSONObject;

public class WarEvent extends HistoricEvent {
    public WarEvent(int id) {
        super(id);
    }

    private String thoiGian; // time
    private String thoiKy; // period
    private String lucLuong; // force
    private String doiPhuong; // competitor
    private String ketQua; // result

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }

    public String getThoiKy() {
        return thoiKy;
    }

    public void setThoiKy(String thoiKy) {
        this.thoiKy = thoiKy;
    }

    public String getLucLuong() {
        return lucLuong;
    }

    public void setLucLuong(String lucLuong) {
        this.lucLuong = lucLuong;
    }

    public String getDoiPhuong() {
        return doiPhuong;
    }

    public void setDoiPhuong(String doiPhuong) {
        this.doiPhuong = doiPhuong;
    }

    public String getKetQua() {
        return ketQua;
    }

    public void setKetQua(String ketQua) {
        this.ketQua = ketQua;
    }

    @Override
    public JSONObject toJSONObject() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", getId());
        jsonObject.put("ten", getTen());
        jsonObject.put("thoiGian", getThoiGian());
        jsonObject.put("thoiKy", getThoiKy());
        jsonObject.put("lucLuong", getLucLuong());
        jsonObject.put("doiPhuong", getDoiPhuong());
        jsonObject.put("moTa", getMoTa());
        jsonObject.put("ketQua", getKetQua());
        return jsonObject;
    }
}
