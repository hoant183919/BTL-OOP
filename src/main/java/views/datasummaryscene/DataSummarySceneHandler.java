package views.datasummaryscene;

import dataprocessingcontroller.SummaryController;
import entity.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import utils.configs.ConfigResourceFXML;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DataSummarySceneHandler implements Initializable {
    private Stage stage;
    private Scene scene;
    @FXML
    public void backtoSplashScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource((ConfigResourceFXML.SPLASH_SCENE_PATH)));
        scene = new Scene(root);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
// Khai bao Historical Dynasty Tableview
    @FXML
    TableView<HistoricalDynasty> historicalDynastyTableView;
    @FXML
    TableColumn<HistoricalDynasty, String> tenHistoricalDynastyColumn;
    @FXML
    TableColumn<HistoricalDynasty, String> kinhDoHistoricalDynastyColumn;
    @FXML
    TableColumn<HistoricalDynasty, String> moTaHistoricalDynastyColumn;
    @FXML
    TableColumn<HistoricalDynasty, String> culturalRelationHistoricalDynastyColumn;
    @FXML
    TableColumn<HistoricalDynasty, String> figureRelationHistoricalDynastyColumn;
    @FXML
    TableColumn<HistoricalDynasty, String> dynastyRelationHistoricalDynastyColumn;
    @FXML
    TableColumn<HistoricalDynasty, String> siteRelationHistoricalDynastyColumn;
    @FXML
    TableColumn<HistoricalDynasty, String> eventRelationHistoricalDynastyColumn;

    // Khai bao Cultural Festival Tableview
    @FXML
    TableView<CulturalFestival> culturalFestivalTableView;
    @FXML
    TableColumn<CulturalFestival, String> tenCulturalFestivalColumn;
    @FXML
    TableColumn<CulturalFestival, String> thoiGianCulturalFestivalColumn;
    @FXML
    TableColumn<CulturalFestival, String> diaDiemCulturalFestivalColumn;
    @FXML
    TableColumn<CulturalFestival, String> thoiDiemToChucLanDauCulturalFestivalColumn;
    @FXML
    TableColumn<CulturalFestival, String> moTaCulturalFestivalColumn;
    @FXML
    TableColumn<CulturalFestival, String> culturalRelationCulturalFestivalColumn;
    @FXML
    TableColumn<CulturalFestival, String> figureRelationCulturalFestivalColumn;
    @FXML
    TableColumn<CulturalFestival, String> dynastyRelationCulturalFestivalColumn;
    @FXML
    TableColumn<CulturalFestival, String> eventRelationCulturalFestivalColumn;
    @FXML
    TableColumn<CulturalFestival, String> siteRelationCulturalFestivalColumn;


    // Khai bao Historical Figure TableView
    @FXML
    TableView<HistoricalFigure> historicalFigureTableView;
    @FXML
    TableColumn<HistoricalFigure, String> tenHistoricalFigureColumn;
    @FXML
    TableColumn<HistoricalFigure, String> mieuHieuHistoricalFigureColumn;
    @FXML
    TableColumn<HistoricalFigure, String> thuyHieuHistoricalFigureColumn;
    @FXML
    TableColumn<HistoricalFigure, String> nienHieuHistoricalFigureColumn;
    @FXML
    TableColumn<HistoricalFigure, String> tenHuyHistoricalFigureColumn;
    @FXML
    TableColumn<HistoricalFigure, String> tenChuHanHistoricalFigureColumn;
    @FXML
    TableColumn<HistoricalFigure, String> namSinhMatHistoricalFigureColumn;
    @FXML
    TableColumn<HistoricalFigure, String> vaiTroHistoricalFigureColumn;
    @FXML
    TableColumn<HistoricalFigure, String> triViHistoricalFigureColumn;
    @FXML
    TableColumn<HistoricalFigure, String> culturalRelationHistoricalFigureColumn;
    @FXML
    TableColumn<HistoricalFigure, String> figureRelationHistoricalFigureColumn;
    @FXML
    TableColumn<HistoricalFigure, String> dynastyRelationHistoricalFigureColumn;
    @FXML
    TableColumn<HistoricalFigure, String> eventRelationHistoricalFigureColumn;
    @FXML
    TableColumn<HistoricalFigure, String> siteRelationHistoricalFigureColumn;

    // Khai bao Historical Site TableView
    @FXML
    TableView<HistoricalSite> historicalSiteTableView;
    @FXML
    TableColumn<HistoricalSite, String> tenHistoricalSiteColumn;
    @FXML
    TableColumn<HistoricalSite, String> diaDiemHistoricalSiteColumn;
    @FXML
    TableColumn<HistoricalSite, String> namCNHistoricalSiteColumn;
    @FXML
    TableColumn<HistoricalSite, String> mieuTaHistoricalSiteColumn;
    @FXML
    TableColumn<HistoricalSite, String> culturalRelationHistoricalSiteColumn;
    @FXML
    TableColumn<HistoricalSite, String> figureRelationHistoricalSiteColumn;
    @FXML
    TableColumn<HistoricalSite, String> dynastyRelationHistoricalSiteColumn;
    @FXML
    TableColumn<HistoricalSite, String> eventRelationHistoricalSiteColumn;
    @FXML
    TableColumn<HistoricalSite, String> siteRelationHistoricalSiteColumn;

    // Khai bao Historic Event TableView
    @FXML
    TableView<HistoricEvent> historicEventTableView;
    @FXML
    TableColumn<HistoricEvent, String> tenHistoricEventColumn;
    @FXML
    TableColumn<HistoricEvent, String> thoiGianHistoricEventColumn;
    @FXML
    TableColumn<HistoricEvent, String> thoiKyHistoricEventColumn;
    @FXML
    TableColumn<HistoricEvent, String> lucLuongHistoricEventColumn;
    @FXML
    TableColumn<HistoricEvent, String> doiPhuongHistoricEventColumn;
    @FXML
    TableColumn<HistoricEvent, String> ketQuaHistoricEventColumn;
    @FXML
    TableColumn<HistoricEvent, String> culturalRelationHistoricEventColumn;
    @FXML
    TableColumn<HistoricEvent, String> figureRelationHistoricEventColumn;
    @FXML
    TableColumn<HistoricEvent, String> dynastyRelationHistoricEventColumn;
    @FXML
    TableColumn<HistoricEvent, String> eventRelationHistoricEventColumn;
    @FXML
    TableColumn<HistoricEvent, String> siteRelationHistoricEventColumn;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        SummaryController summaryController = new SummaryController();

        // Set Historical Dynasty TableView
        tenHistoricalDynastyColumn.setCellValueFactory(new PropertyValueFactory<HistoricalDynasty, String>("ten"));
        kinhDoHistoricalDynastyColumn.setCellValueFactory(new PropertyValueFactory<HistoricalDynasty, String>("kinhDo"));
        moTaHistoricalDynastyColumn.setCellValueFactory(new PropertyValueFactory<HistoricalDynasty, String>("moTa"));
        culturalRelationHistoricalDynastyColumn.setCellValueFactory(new PropertyValueFactory<HistoricalDynasty, String>("leHoiLienQuan"));
        figureRelationHistoricalDynastyColumn.setCellValueFactory(new PropertyValueFactory<HistoricalDynasty, String>("nhanVatLienQuan"));
        dynastyRelationHistoricalDynastyColumn.setCellValueFactory(new PropertyValueFactory<HistoricalDynasty, String>("trieuDaiLienQuan"));
        eventRelationHistoricalDynastyColumn.setCellValueFactory(new PropertyValueFactory<HistoricalDynasty, String>("suKienLienQuan"));
        siteRelationHistoricalDynastyColumn.setCellValueFactory(new PropertyValueFactory<HistoricalDynasty, String>("diTichLienQuan"));
        historicalDynastyTableView.setItems(summaryController.getAllHistoricalDynasty());

        // Set Cultural Festival TableView
        tenCulturalFestivalColumn.setCellValueFactory(new PropertyValueFactory<CulturalFestival, String>("ten"));
        thoiGianCulturalFestivalColumn.setCellValueFactory(new PropertyValueFactory<CulturalFestival, String>("thoiGian"));
        diaDiemCulturalFestivalColumn.setCellValueFactory(new PropertyValueFactory<CulturalFestival, String>("diaDiem"));
        thoiDiemToChucLanDauCulturalFestivalColumn.setCellValueFactory(new PropertyValueFactory<CulturalFestival, String>("thoiDiemToChucLanDau"));
        moTaCulturalFestivalColumn.setCellValueFactory(new PropertyValueFactory<CulturalFestival, String>("moTa"));
        culturalRelationCulturalFestivalColumn.setCellValueFactory(new PropertyValueFactory<CulturalFestival, String>("leHoiLienQuan"));
        figureRelationCulturalFestivalColumn.setCellValueFactory(new PropertyValueFactory<CulturalFestival, String>("nhanVatLienQuan"));
        dynastyRelationCulturalFestivalColumn.setCellValueFactory(new PropertyValueFactory<CulturalFestival, String>("trieuDaiLienQuan"));
        eventRelationCulturalFestivalColumn.setCellValueFactory(new PropertyValueFactory<CulturalFestival, String>("suKienLienQuan"));
        siteRelationCulturalFestivalColumn.setCellValueFactory(new PropertyValueFactory<CulturalFestival, String>("diTichLienQuan"));
        culturalFestivalTableView.setItems(summaryController.getAllCulturalFestival());

        // Set Historical Figure TableView
        tenHistoricalFigureColumn.setCellValueFactory(new PropertyValueFactory<HistoricalFigure, String>("ten"));
        mieuHieuHistoricalFigureColumn.setCellValueFactory(new PropertyValueFactory<HistoricalFigure, String>("mieuHieu"));
        thuyHieuHistoricalFigureColumn.setCellValueFactory(new PropertyValueFactory<HistoricalFigure, String>("thuyHieu"));
        nienHieuHistoricalFigureColumn.setCellValueFactory(new PropertyValueFactory<HistoricalFigure, String>("nienHieu"));
        tenHuyHistoricalFigureColumn.setCellValueFactory(new PropertyValueFactory<HistoricalFigure, String>("tenHuy"));
        tenChuHanHistoricalFigureColumn.setCellValueFactory(new PropertyValueFactory<HistoricalFigure, String>("tenChuHan"));
        namSinhMatHistoricalFigureColumn.setCellValueFactory(new PropertyValueFactory<HistoricalFigure, String>("namSinhMat"));
        vaiTroHistoricalFigureColumn.setCellValueFactory(new PropertyValueFactory<HistoricalFigure, String>("vaiTro"));
        triViHistoricalFigureColumn.setCellValueFactory(new PropertyValueFactory<HistoricalFigure, String>("triVi"));
        culturalRelationHistoricalFigureColumn.setCellValueFactory(new PropertyValueFactory<HistoricalFigure, String>("leHoiLienQuan"));
        figureRelationHistoricalFigureColumn.setCellValueFactory(new PropertyValueFactory<HistoricalFigure, String>("nhanVatLienQuan"));
        dynastyRelationHistoricalFigureColumn.setCellValueFactory(new PropertyValueFactory<HistoricalFigure, String>("trieuDaiLienQuan"));
        eventRelationHistoricalFigureColumn.setCellValueFactory(new PropertyValueFactory<HistoricalFigure, String>("suKienLienQuan"));
        siteRelationHistoricalFigureColumn.setCellValueFactory(new PropertyValueFactory<HistoricalFigure, String>("diTichLienQuan"));
        historicalFigureTableView.setItems(summaryController.getAllHistoricalFigure());

        // Set Historical Site TableView
        tenHistoricalSiteColumn.setCellValueFactory(new PropertyValueFactory<HistoricalSite, String>("ten"));
        diaDiemHistoricalSiteColumn.setCellValueFactory(new PropertyValueFactory<HistoricalSite, String>("diaDiem"));
        namCNHistoricalSiteColumn.setCellValueFactory(new PropertyValueFactory<HistoricalSite, String>("namCN"));
        mieuTaHistoricalSiteColumn.setCellValueFactory(new PropertyValueFactory<HistoricalSite, String>("mieuTa"));
        culturalRelationHistoricalSiteColumn.setCellValueFactory(new PropertyValueFactory<HistoricalSite, String>("leHoiLienQuan"));
        figureRelationHistoricalSiteColumn.setCellValueFactory(new PropertyValueFactory<HistoricalSite, String>("nhanVatLienQuan"));
        dynastyRelationHistoricalSiteColumn.setCellValueFactory(new PropertyValueFactory<HistoricalSite, String>("trieuDaiLienQuan"));
        eventRelationHistoricalSiteColumn.setCellValueFactory(new PropertyValueFactory<HistoricalSite, String>("suKienLienQuan"));
        siteRelationHistoricalSiteColumn.setCellValueFactory(new PropertyValueFactory<HistoricalSite, String>("diTichLienQuan"));
        historicalSiteTableView.setItems(summaryController.getAllHistoricalSite());

        // Set Historic Event TableView
        tenHistoricEventColumn.setCellValueFactory(new PropertyValueFactory<HistoricEvent, String>("ten"));
        thoiGianHistoricEventColumn.setCellValueFactory(new PropertyValueFactory<HistoricEvent, String>("thoiGian"));
        thoiKyHistoricEventColumn.setCellValueFactory(new PropertyValueFactory<HistoricEvent, String>("thoiKy"));
        lucLuongHistoricEventColumn.setCellValueFactory(new PropertyValueFactory<HistoricEvent, String>("lucLuong"));
        doiPhuongHistoricEventColumn.setCellValueFactory(new PropertyValueFactory<HistoricEvent, String>("doiPhuong"));
        ketQuaHistoricEventColumn.setCellValueFactory(new PropertyValueFactory<HistoricEvent, String>("ketQua"));
        culturalRelationHistoricEventColumn.setCellValueFactory(new PropertyValueFactory<HistoricEvent, String>("leHoiLienQuan"));
        figureRelationHistoricEventColumn.setCellValueFactory(new PropertyValueFactory<HistoricEvent, String>("nhanVatLienQuan"));
        dynastyRelationHistoricEventColumn.setCellValueFactory(new PropertyValueFactory<HistoricEvent, String>("trieuDaiLienQuan"));
        eventRelationHistoricEventColumn.setCellValueFactory(new PropertyValueFactory<HistoricEvent, String>("suKienLienQuan"));
        siteRelationHistoricEventColumn.setCellValueFactory(new PropertyValueFactory<HistoricEvent, String>("diTichLienQuan"));
        historicEventTableView.setItems(summaryController.getAllHistoricEvent());
    }
}



