package entity;

public class HistoricalSite extends BaseEntity{
    public HistoricalSite(int id) {
        super(id);
    }

    private String tenDiTich;
    private String diaDiem;
    private String namCN;
    private String loaiDiTich;
    private String ghiChu;
    private String mieuTa;
    private String moTa;

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
}
