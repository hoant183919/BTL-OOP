package views.searchscene;

import dataprocessingcontroller.searchcontrollerimpl.*;
import entity.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import utils.SearchType;
import utils.configs.ConfigResourceFXML;

import java.io.IOException;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class SearchSceneHandler implements Initializable {
    @FXML
    MenuItem historicalDynastySearch;
    @FXML
    MenuItem historicalFigureSearch;
    @FXML
    MenuItem historicalSiteSearch;
    @FXML
    MenuItem historicEventSearch;
    @FXML
    MenuItem culturalFestivalSearch;
    @FXML
    TextField keyWord;

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


    private SearchType searchType;
    @FXML
    public void setSearchType(ActionEvent event ) {
        MenuItem mi = (MenuItem) event.getSource();
        if(mi == historicalDynastySearch) {
            searchType = SearchType.HISTORICAL_DYNASTY;
        } else if (mi == historicalFigureSearch) {
            searchType = SearchType.HISTORICAL_FIGURE;

        } else if (mi == historicalSiteSearch) {
            searchType = SearchType.HISTORICAL_SITE;

        } else if (mi == historicEventSearch) {
            searchType = SearchType.HISTORIC_EVENT;

        } else if (mi == culturalFestivalSearch) {
            searchType = SearchType.CULTURAL_FESTIVAL;
        }
    }
    @FXML
    public void search() {
        if (searchType == SearchType.HISTORICAL_DYNASTY) {
            SearchHistoricalDynastyController searchHistoricalDynastyController = new SearchHistoricalDynastyController();
            List<HistoricalDynasty> historicalDynastyList = searchHistoricalDynastyController.searchByKeyWord(keyWord.getText());
            ObservableList<HistoricalDynasty> historicalDynastyObservableList = FXCollections.observableList(historicalDynastyList);
            tenHistoricalDynastyColumn.setCellValueFactory(new PropertyValueFactory<HistoricalDynasty, String>("ten"));
            kinhDoHistoricalDynastyColumn.setCellValueFactory(new PropertyValueFactory<HistoricalDynasty, String>("kinhDo"));
            moTaHistoricalDynastyColumn.setCellValueFactory(new PropertyValueFactory<HistoricalDynasty, String>("moTa"));
            historicalDynastyTableView.setItems(historicalDynastyObservableList);
            showTableView(historicalDynastyTableView);
            hideTableView(culturalFestivalTableView);
            hideTableView(historicalFigureTableView);
            hideTableView(historicalSiteTableView);
            hideTableView(historicEventTableView);

        } else if (searchType == SearchType.HISTORICAL_SITE) {
            SearchHistoricalSiteController searchHistoricalSiteController = new SearchHistoricalSiteController();
            List<HistoricalSite> historicalSiteList = searchHistoricalSiteController.searchByKeyWord(keyWord.getText());
            ObservableList<HistoricalSite> historicalSiteObservableList = FXCollections.observableList(historicalSiteList);
            tenHistoricalSiteColumn.setCellValueFactory(new PropertyValueFactory<HistoricalSite, String>("ten"));
            diaDiemHistoricalSiteColumn.setCellValueFactory(new PropertyValueFactory<HistoricalSite, String>("diaDiem"));
            namCNHistoricalSiteColumn.setCellValueFactory(new PropertyValueFactory<HistoricalSite, String>("namCN"));
            mieuTaHistoricalSiteColumn.setCellValueFactory(new PropertyValueFactory<HistoricalSite, String>("mieuTa"));
            historicalSiteTableView.setItems(historicalSiteObservableList);
            showTableView(historicalSiteTableView);
            hideTableView(culturalFestivalTableView);
            hideTableView(historicalDynastyTableView);
            hideTableView(historicalFigureTableView);
            hideTableView(historicEventTableView);

        } else if (searchType == SearchType.CULTURAL_FESTIVAL) {
            SearchCulturalFestivalController searchCulturalFestivalController = new SearchCulturalFestivalController();
            List<CulturalFestival> culturalFestivalList = searchCulturalFestivalController.searchByKeyWord(keyWord.getText());
            ObservableList<CulturalFestival> culturalFestivalObservableList = FXCollections.observableList(culturalFestivalList);
            tenCulturalFestivalColumn.setCellValueFactory(new PropertyValueFactory<CulturalFestival, String>("ten"));
            thoiGianCulturalFestivalColumn.setCellValueFactory(new PropertyValueFactory<CulturalFestival, String>("thoiGian"));
            diaDiemCulturalFestivalColumn.setCellValueFactory(new PropertyValueFactory<CulturalFestival, String>("diaDiem"));
            thoiDiemToChucLanDauCulturalFestivalColumn.setCellValueFactory(new PropertyValueFactory<CulturalFestival, String>("thoiDiemToChucLanDau"));
            moTaCulturalFestivalColumn.setCellValueFactory(new PropertyValueFactory<CulturalFestival, String>("moTa"));
            culturalFestivalTableView.setItems(culturalFestivalObservableList);
            showTableView(culturalFestivalTableView);
            hideTableView(historicalDynastyTableView);
            hideTableView(historicalFigureTableView);
            hideTableView(historicalSiteTableView);
            hideTableView(historicEventTableView);

        } else if (searchType == SearchType.HISTORICAL_FIGURE) {
            SearchHistoricalFigureController searchHistoricalFigureController = new SearchHistoricalFigureController();
            List<HistoricalFigure> historicalFigureList = searchHistoricalFigureController.searchByKeyWord(keyWord.getText());
            ObservableList<HistoricalFigure> historicalFigureObservableList = FXCollections.observableList(historicalFigureList);
            tenHistoricalFigureColumn.setCellValueFactory(new PropertyValueFactory<HistoricalFigure, String>("ten"));
            mieuHieuHistoricalFigureColumn.setCellValueFactory(new PropertyValueFactory<HistoricalFigure, String>("mieuHieu"));
            thuyHieuHistoricalFigureColumn.setCellValueFactory(new PropertyValueFactory<HistoricalFigure, String>("thuyHieu"));
            nienHieuHistoricalFigureColumn.setCellValueFactory(new PropertyValueFactory<HistoricalFigure, String>("nienHieu"));
            tenHuyHistoricalFigureColumn.setCellValueFactory(new PropertyValueFactory<HistoricalFigure, String>("tenHuy"));
            tenChuHanHistoricalFigureColumn.setCellValueFactory(new PropertyValueFactory<HistoricalFigure, String>("tenChuHan"));
            namSinhMatHistoricalFigureColumn.setCellValueFactory(new PropertyValueFactory<HistoricalFigure, String>("namSinhMat"));
            vaiTroHistoricalFigureColumn.setCellValueFactory(new PropertyValueFactory<HistoricalFigure, String>("vaiTro"));
            triViHistoricalFigureColumn.setCellValueFactory(new PropertyValueFactory<HistoricalFigure, String>("triVi"));
            historicalFigureTableView.setItems(historicalFigureObservableList);
            showTableView(historicalFigureTableView);
            hideTableView(culturalFestivalTableView);
            hideTableView(historicalDynastyTableView);
            hideTableView(historicalSiteTableView);
            hideTableView(historicEventTableView);

        } else if (searchType == SearchType.HISTORIC_EVENT) {
            SearchHistoricEventController searchHistoricEventController = new SearchHistoricEventController();
            List<HistoricEvent> historicEventList = searchHistoricEventController.searchByKeyWord(keyWord.getText());
            ObservableList<HistoricEvent> historicEventObservableList = FXCollections.observableList(historicEventList);
            tenHistoricEventColumn.setCellValueFactory(new PropertyValueFactory<HistoricEvent, String>("ten"));
            thoiGianHistoricEventColumn.setCellValueFactory(new PropertyValueFactory<HistoricEvent, String>("thoiGian"));
            thoiKyHistoricEventColumn.setCellValueFactory(new PropertyValueFactory<HistoricEvent, String>("thoiKy"));
            lucLuongHistoricEventColumn.setCellValueFactory(new PropertyValueFactory<HistoricEvent, String>("lucLuong"));
            doiPhuongHistoricEventColumn.setCellValueFactory(new PropertyValueFactory<HistoricEvent, String>("doiPhuong"));
            ketQuaHistoricEventColumn.setCellValueFactory(new PropertyValueFactory<HistoricEvent, String>("ketQua"));
            historicEventTableView.setItems(historicEventObservableList);
            showTableView(historicEventTableView);
            hideTableView(culturalFestivalTableView);
            hideTableView(historicalDynastyTableView);
            hideTableView(historicalFigureTableView);
            hideTableView(historicalSiteTableView);

        } else if (searchType == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Lưu ý");
            alert.setContentText("Hãy chọn thể loại cần tìm kiếm");
            alert.show();
        }
    }

    // Show Detail
    @FXML
    public void detail(ActionEvent event ) throws IOException {

       // Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();

        if (searchType == SearchType.HISTORICAL_DYNASTY) {
            loader.setLocation(getClass().getResource(ConfigResourceFXML.HISTORICAL_DYNASTY_SCENE));
            Parent historicalDynastyScene = loader.load();
            Scene scene = new Scene(historicalDynastyScene);
            HistoricalDynastySceneHandler historicalDynastySceneController = loader.getController();
            HistoricalDynasty selected = historicalDynastyTableView.getSelectionModel().getSelectedItem();
            historicalDynastySceneController.setHistoricalDynasty(selected);
            stage.setScene(scene);
            stage.show();
        } else if (searchType == SearchType.CULTURAL_FESTIVAL) {
            loader.setLocation(getClass().getResource(ConfigResourceFXML.CULTURAL_FESTIVAL_SCENE));
            Parent culturalFestivalScene = loader.load();
            Scene scene = new Scene(culturalFestivalScene);
            CulturalFestivalSceneHandler culturalFestivalSceneController = loader.getController();
            CulturalFestival selected = culturalFestivalTableView.getSelectionModel().getSelectedItem();
            culturalFestivalSceneController.setCulturalFestival(selected);
            stage.setScene(scene);
            stage.show();
        } else if (searchType == SearchType.HISTORICAL_SITE) {
            loader.setLocation(getClass().getResource(ConfigResourceFXML.HISTORICAL_SITE_SCENE));
            Parent historicalSiteScene = loader.load();
            Scene scene = new Scene(historicalSiteScene);
            HistoricalSiteSceneHandler historicalSiteSceneController = loader.getController();
            HistoricalSite selected = historicalSiteTableView.getSelectionModel().getSelectedItem();
            historicalSiteSceneController.setHistoricalSite(selected);
            stage.setScene(scene);
            stage.show();
        } else if (searchType == SearchType.HISTORICAL_FIGURE) {
            loader.setLocation(getClass().getResource(ConfigResourceFXML.HISTORICAL_FIGURE_SCENE));
            Parent historicalFigureScene = loader.load();
            Scene scene = new Scene(historicalFigureScene);
            HistoricalFigureSceneHandler historicalFigureSceneController = loader.getController();
            HistoricalFigure selected = historicalFigureTableView.getSelectionModel().getSelectedItem();
            historicalFigureSceneController.setHistoricalFigure(selected);
            stage.setScene(scene);
            stage.show();
        } else if (searchType == SearchType.HISTORIC_EVENT) {
            loader.setLocation(getClass().getResource(ConfigResourceFXML.HISTORIC_EVENT_SCENE));
            Parent historicEventScene = loader.load();
            Scene scene = new Scene(historicEventScene);
            HistoricEventSceneHandler historicEventSceneController = loader.getController();
            HistoricEvent selected = historicEventTableView.getSelectionModel().getSelectedItem();
            historicEventSceneController.setHistoricEvent(selected);
            stage.setScene(scene);
            stage.show();
        }
    }
    @FXML
    public void backToSplashScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(ConfigResourceFXML.SPLASH_SCENE_PATH));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        hideTableView(culturalFestivalTableView);
        hideTableView(historicalDynastyTableView);
        hideTableView(historicalFigureTableView);
        hideTableView(historicalSiteTableView);
        hideTableView(historicEventTableView);
    }
    public void hideTableView(TableView tableView){
        tableView.setDisable(true);
        tableView.setOpacity(0);
    }
    public void showTableView(TableView tableView){
        tableView.setOpacity(1);
        tableView.setDisable(false);
    }
}