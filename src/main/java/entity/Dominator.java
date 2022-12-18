package entity;

import org.json.simple.JSONObject;

public class Dominator extends HistoricalFigure{
    private String ten; // figureName
    private String vaiTro; // role
    private String mieuHieu;
    private String thuyHieu;
    private String nienHieu;
    private String tenHuy;
    private String theThu;
    private String triVi;
    private String moTa; // description
    private String tenChuHan; // kanjiName
    private String namSinhMat; // dateOfBirthAndPassed

    public String getTenChuHan() {
        return tenChuHan;
    }

    public void setTenChuHan(String tenChuHan) {
        this.tenChuHan = tenChuHan;
    }

    public String getNamSinhMat() {
        return namSinhMat;
    }

    public void setNamSinhMat(String namSinhMat) {
        this.namSinhMat = namSinhMat;
    }

    public Dominator(int id) {
        super(id);
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(String vaiTro) {
        this.vaiTro = vaiTro;
    }

    public String getMieuHieu() {
        return mieuHieu;
    }

    public void setMieuHieu(String mieuHieu) {
        this.mieuHieu = mieuHieu;
    }

    public String getThuyHieu() {
        return thuyHieu;
    }

    public void setThuyHieu(String thuyHieu) {
        this.thuyHieu = thuyHieu;
    }

    public String getNienHieu() {
        return nienHieu;
    }

    public void setNienHieu(String nienHieu) {
        this.nienHieu = nienHieu;
    }

    public String getTenHuy() {
        return tenHuy;
    }

    public void setTenHuy(String tenHuy) {
        this.tenHuy = tenHuy;
    }

    public String getTheThu() {
        return theThu;
    }

    public void setTheThu(String theThu) {
        this.theThu = theThu;
    }

    public String getTriVi() {
        return triVi;
    }

    public void setTriVi(String triVi) {
        this.triVi = triVi;
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
        jsonObject.put("vaiTro", getVaiTro());
        jsonObject.put("mieuHieu", getMieuHieu());
        jsonObject.put("thuyHieu", getThuyHieu());
        jsonObject.put("nienHieu", getNienHieu());
        jsonObject.put("tenHuy", getTenHuy());
        jsonObject.put("theThu", getTheThu());
        jsonObject.put("triVi", getTriVi());
        jsonObject.put("moTa", getMoTa());
        jsonObject.put("tenChuHan", getTenChuHan());
        jsonObject.put("namSinhMat", getNamSinhMat());
        return jsonObject;
    }
}
