package entity;

import java.util.HashMap;

public class HistoricalFigure extends BaseEntity{
    public HistoricalFigure(int id) {
        super(id);
    }
    private String tenThat;
    private String tenHieu;
    private String namSinh;
    private String namMat;
    private String chucVu;
    private String thoiDiemLenNgoi;
    private String thoiGianTaiChuc;
    private HashMap<String, String> nguoiThan;
    private String moTa;
}
