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

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DataSummarySceneHandler implements Initializable {
    private Stage stage;
    private Scene scene;
    @FXML
    public void backtoSplashScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(("/SplashScene.fxml")));
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

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        SummaryController summaryController = new SummaryController();

        // Set Historical Dynasty TableView
        tenHistoricalDynastyColumn.setCellValueFactory(new PropertyValueFactory<HistoricalDynasty, String>("ten"));
        kinhDoHistoricalDynastyColumn.setCellValueFactory(new PropertyValueFactory<HistoricalDynasty, String>("kinhDo"));
        moTaHistoricalDynastyColumn.setCellValueFactory(new PropertyValueFactory<HistoricalDynasty, String>("moTa"));
        historicalDynastyTableView.setItems(summaryController.getAllHistoricalDynasty());

        // Set Cultural Festival TableView
        tenCulturalFestivalColumn.setCellValueFactory(new PropertyValueFactory<CulturalFestival, String>("ten"));
        thoiGianCulturalFestivalColumn.setCellValueFactory(new PropertyValueFactory<CulturalFestival, String>("thoiGian"));
        diaDiemCulturalFestivalColumn.setCellValueFactory(new PropertyValueFactory<CulturalFestival, String>("diaDiem"));
        thoiDiemToChucLanDauCulturalFestivalColumn.setCellValueFactory(new PropertyValueFactory<CulturalFestival, String>("thoiDiemToChucLanDau"));
        moTaCulturalFestivalColumn.setCellValueFactory(new PropertyValueFactory<CulturalFestival, String>("moTa"));
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
        historicalFigureTableView.setItems(summaryController.getAllHistoricalFigure());


        // Set Historical Site TableView
        tenHistoricalSiteColumn.setCellValueFactory(new PropertyValueFactory<HistoricalSite, String>("ten"));
        diaDiemHistoricalSiteColumn.setCellValueFactory(new PropertyValueFactory<HistoricalSite, String>("diaDiem"));
        namCNHistoricalSiteColumn.setCellValueFactory(new PropertyValueFactory<HistoricalSite, String>("namCN"));
        mieuTaHistoricalSiteColumn.setCellValueFactory(new PropertyValueFactory<HistoricalSite, String>("mieuTa"));
        historicalSiteTableView.setItems(summaryController.getAllHistoricalSite());

        // Set Historic Event TableView
        tenHistoricEventColumn.setCellValueFactory(new PropertyValueFactory<HistoricEvent, String>("ten"));
        thoiGianHistoricEventColumn.setCellValueFactory(new PropertyValueFactory<HistoricEvent, String>("thoiGian"));
        thoiKyHistoricEventColumn.setCellValueFactory(new PropertyValueFactory<HistoricEvent, String>("thoiKy"));
        lucLuongHistoricEventColumn.setCellValueFactory(new PropertyValueFactory<HistoricEvent, String>("lucLuong"));
        doiPhuongHistoricEventColumn.setCellValueFactory(new PropertyValueFactory<HistoricEvent, String>("doiPhuong"));
        ketQuaHistoricEventColumn.setCellValueFactory(new PropertyValueFactory<HistoricEvent, String>("ketQua"));
        historicEventTableView.setItems(summaryController.getAllHistoricEvent());
    }
}



