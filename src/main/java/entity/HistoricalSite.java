package entity;

import org.json.simple.JSONObject;

public class HistoricalSite extends BaseEntity{
    public HistoricalSite(int id) {
        super(id);
    }

    private String tenDiTich; // siteName
    private String diaDiem; // location
    private String namCN; // yearOfRecognition
    private String loaiDiTich; //typeSite
    private String ghiChu; // note
    private String mieuTa; // depiction
    private String moTa; // description

    public HistoricalSite(int id, String tenDiTich, String diaDiem, String namCN, String loaiDiTich, String ghiChu, String mieuTa, String moTa) {
        super(id);
        this.tenDiTich = tenDiTich;
        this.diaDiem = diaDiem;
        this.namCN = namCN;
        this.loaiDiTich = loaiDiTich;
        this.ghiChu = ghiChu;
        this.mieuTa = mieuTa;
        this.moTa = moTa;
    }

    public String getTenDiTich() {
        return tenDiTich;
    }

    public void setTenDiTich(String tenDiTich) {
        this.tenDiTich = tenDiTich;
    }

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

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public JSONObject toJSONObject(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", getId());
        jsonObject.put("ten", getTenDiTich());
        jsonObject.put("diaDiem", getDiaDiem());
        jsonObject.put("namCN", getNamCN());
        jsonObject.put("ghiChu", getGhiChu());
        jsonObject.put("moTa", getMoTa());
        jsonObject.put("mieuTa", getMieuTa());
        return jsonObject;
    }
}
