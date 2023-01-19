package views.datasummaryscene;

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

public class DataSummarySceneController implements Initializable {
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
    TableView<Dominator> historicalFigureTableView;
    @FXML
    TableColumn<Dominator, String> tenHistoricalFigureColumn;
    @FXML
    TableColumn<Dominator, String> mieuHieuHistoricalFigureColumn;
    @FXML
    TableColumn<Dominator, String> thuyHieuHistoricalFigureColumn;
    @FXML
    TableColumn<Dominator, String> nienHieuHistoricalFigureColumn;
    @FXML
    TableColumn<Dominator, String> tenHuyHistoricalFigureColumn;
    @FXML
    TableColumn<Dominator, String> tenChuHanHistoricalFigureColumn;
    @FXML
    TableColumn<Dominator, String> namSinhMatHistoricalFigureColumn;
    @FXML
    TableColumn<Dominator, String> vaiTroHistoricalFigureColumn;
    @FXML
    TableColumn<Dominator, String> triViHistoricalFigureColumn;

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
    TableView<WarEvent> historicEventTableView;
    @FXML
    TableColumn<WarEvent, String> tenHistoricEventColumn;
    @FXML
    TableColumn<WarEvent, String> thoiGianHistoricEventColumn;
    @FXML
    TableColumn<WarEvent, String> thoiKyHistoricEventColumn;
    @FXML
    TableColumn<WarEvent, String> lucLuongHistoricEventColumn;
    @FXML
    TableColumn<WarEvent, String> doiPhuongHistoricEventColumn;
    @FXML
    TableColumn<WarEvent, String> ketQuaHistoricEventColumn;

    String[] historicalDynastyData = {
            "src\\main\\java\\data\\reservedata\\wikipedia\\historicaldynasties.json",
            "src\\main\\java\\data\\reservedata\\nguoikesu\\historicaldynasties.json"
    };
    String[] culturalFestivalData = {
            "src\\main\\java\\data\\reservedata\\wikipedia\\culturalfestivals.json",
            "src\\main\\java\\data\\reservedata\\nguoikesu\\culturalfestivals.json"
    };
    String[] historicalFigureData = {
            "src\\main\\java\\data\\reservedata\\wikipedia\\historicalfigures.json",
            "src\\main\\java\\data\\reservedata\\nguoikesu\\historicalfigures.json"
    };
    String[] historicalSiteData = {
            "src\\main\\java\\data\\reservedata\\wikipedia\\historicalsites.json",
            "src\\main\\java\\data\\reservedata\\nguoikesu\\historicalsites.json"
    };
    String[] historicEventData = {
            "src\\main\\java\\data\\reservedata\\wikipedia\\historicevents.json",
            "src\\main\\java\\data\\reservedata\\nguoikesu\\historicevents.json"
    };




    DataSummary dataSummary = new DataSummary();
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        // Set Historical Dynasty TableView
        tenHistoricalDynastyColumn.setCellValueFactory(new PropertyValueFactory<HistoricalDynasty, String>("ten"));
        kinhDoHistoricalDynastyColumn.setCellValueFactory(new PropertyValueFactory<HistoricalDynasty, String>("kinhDo"));
        moTaHistoricalDynastyColumn.setCellValueFactory(new PropertyValueFactory<HistoricalDynasty, String>("moTa"));
        try {
            historicalDynastyTableView.setItems(dataSummary.historicalDynastyDataSummary(historicalDynastyData));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Set Cultural Festival TableView
        tenCulturalFestivalColumn.setCellValueFactory(new PropertyValueFactory<CulturalFestival, String>("ten"));
        thoiGianCulturalFestivalColumn.setCellValueFactory(new PropertyValueFactory<CulturalFestival, String>("thoiGian"));
        diaDiemCulturalFestivalColumn.setCellValueFactory(new PropertyValueFactory<CulturalFestival, String>("diaDiem"));
        thoiDiemToChucLanDauCulturalFestivalColumn.setCellValueFactory(new PropertyValueFactory<CulturalFestival, String>("thoiDiemToChucLanDau"));
        moTaCulturalFestivalColumn.setCellValueFactory(new PropertyValueFactory<CulturalFestival, String>("moTa"));


        try {

            culturalFestivalTableView.setItems(dataSummary.culturalFestivalDataSummary(culturalFestivalData));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Set Historical Figure TableView
        tenHistoricalFigureColumn.setCellValueFactory(new PropertyValueFactory<Dominator, String>("ten"));
        mieuHieuHistoricalFigureColumn.setCellValueFactory(new PropertyValueFactory<Dominator, String>("mieuHieu"));
        thuyHieuHistoricalFigureColumn.setCellValueFactory(new PropertyValueFactory<Dominator, String>("thuyHieu"));
        nienHieuHistoricalFigureColumn.setCellValueFactory(new PropertyValueFactory<Dominator, String>("nienHieu"));
        tenHuyHistoricalFigureColumn.setCellValueFactory(new PropertyValueFactory<Dominator, String>("tenHuy"));
        tenChuHanHistoricalFigureColumn.setCellValueFactory(new PropertyValueFactory<Dominator, String>("tenChuHan"));
        namSinhMatHistoricalFigureColumn.setCellValueFactory(new PropertyValueFactory<Dominator, String>("namSinhMat"));
        vaiTroHistoricalFigureColumn.setCellValueFactory(new PropertyValueFactory<Dominator, String>("vaiTro"));
        triViHistoricalFigureColumn.setCellValueFactory(new PropertyValueFactory<Dominator, String>("triVi"));
        try {
            historicalFigureTableView.setItems(dataSummary.historicalFigureDataSummary(historicalFigureData));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Set Historical Site TableView
        tenHistoricalSiteColumn.setCellValueFactory(new PropertyValueFactory<HistoricalSite, String>("ten"));
        diaDiemHistoricalSiteColumn.setCellValueFactory(new PropertyValueFactory<HistoricalSite, String>("diaDiem"));
        namCNHistoricalSiteColumn.setCellValueFactory(new PropertyValueFactory<HistoricalSite, String>("namCN"));
        mieuTaHistoricalSiteColumn.setCellValueFactory(new PropertyValueFactory<HistoricalSite, String>("mieuTa"));
        try {
            historicalSiteTableView.setItems(dataSummary.historicalSiteDataSummary(historicalSiteData));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Set Historic Event TableView
        tenHistoricEventColumn.setCellValueFactory(new PropertyValueFactory<WarEvent, String>("ten"));
        thoiGianHistoricEventColumn.setCellValueFactory(new PropertyValueFactory<WarEvent, String>("thoiGian"));
        thoiKyHistoricEventColumn.setCellValueFactory(new PropertyValueFactory<WarEvent, String>("thoiKy"));
        lucLuongHistoricEventColumn.setCellValueFactory(new PropertyValueFactory<WarEvent, String>("lucLuong"));
        doiPhuongHistoricEventColumn.setCellValueFactory(new PropertyValueFactory<WarEvent, String>("doiPhuong"));
        ketQuaHistoricEventColumn.setCellValueFactory(new PropertyValueFactory<WarEvent, String>("ketQua"));
        try {
            historicEventTableView.setItems(dataSummary.historicEventDataSummary(historicEventData));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }




}



