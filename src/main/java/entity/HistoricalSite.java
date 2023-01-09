package entity;

import org.json.simple.JSONObject;

public class HistoricalSite extends BaseEntity{
    public HistoricalSite(int id) {
        super(id);
    }

    private String diaDiem; // location
    private String namCN; // yearOfRecognition
    private String loaiDiTich; //typeSite
    private String ghiChu; // note
    private String mieuTa; // depiction

    public String getDiaDiem() {
        return diaDiem;
    }

    public void setDiaDiem(String diaDiem) {
        this.diaDiem = diaDiem;
    }

    public String getNamCN() {
        return namCN;
    }

    public void setNamCN(String namCN) {
        this.namCN = namCN;
    }

    public String getLoaiDiTich() {
        return loaiDiTich;
    }

    public void setLoaiDiTich(String loaiDiTich) {
        this.loaiDiTich = loaiDiTich;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getMieuTa() {
        return mieuTa;
    }

    public void setMieuTa(String mieuTa) {
        this.mieuTa = mieuTa;
    }

    public JSONObject toJSONObject(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", getId());
        jsonObject.put("ten", getTen());
        jsonObject.put("diaDiem", getDiaDiem());
        jsonObject.put("namCN", getNamCN());
        jsonObject.put("ghiChu", getGhiChu());
        jsonObject.put("moTa", getMoTa());
        jsonObject.put("mieuTa", getMieuTa());
        return jsonObject;
    }
}
