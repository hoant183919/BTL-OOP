package entity;

import org.json.simple.JSONObject;

public class CulturalFestival extends BaseEntity{
    public CulturalFestival(int id) {
        super(id);
    }
    private String ten; // festivalName
    private String thoiDiemToChucLanDau; // timeFirstOrganize
    private String diaDiem; // location
    private String quyMoLeHoi;
    private String thoiGian; // time
    private String moTa; // description
    private String ghiChu; // note

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
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

    public String getQuyMoLeHoi() {
        return quyMoLeHoi;
    }

    public void setQuyMoLeHoi(String quyMoLeHoi) {
        this.quyMoLeHoi = quyMoLeHoi;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
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
        return jsonObject;
    }
}
