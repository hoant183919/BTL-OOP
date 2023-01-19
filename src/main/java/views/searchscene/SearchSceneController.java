package views.searchscene;

import dataprocessingcontroller.searchcontrollerimpl.*;
import entity.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import utils.SearchType;

import java.io.IOException;
import java.util.List;


public class SearchSceneController {
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
    @FXML
    ListView listResult;

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
        if(searchType == SearchType.HISTORICAL_DYNASTY) {
            SearchHistoricalDynastyController searchHistoricalDynastyController = new SearchHistoricalDynastyController();
            List<HistoricalDynasty> historicalDynastyList = searchHistoricalDynastyController.searchByKeyWord(keyWord.getText());
            ObservableList<HistoricalDynasty> historicalDynastyObservableList = FXCollections.observableList(historicalDynastyList);
            listResult.setItems(historicalDynastyObservableList);

        } else if (searchType == SearchType.HISTORICAL_SITE) {
            SearchHistoricalSiteController searchHistoricalSiteController = new SearchHistoricalSiteController();
            List<HistoricalSite> historicalSiteList = searchHistoricalSiteController.searchByKeyWord(keyWord.getText());
            ObservableList<HistoricalSite> historicalSiteObservableList = FXCollections.observableList(historicalSiteList);
            listResult.setItems(historicalSiteObservableList);
        } else if (searchType == SearchType.CULTURAL_FESTIVAL) {
            SearchCulturalFestivalController searchCulturalFestivalController = new SearchCulturalFestivalController();
            List<CulturalFestival> culturalFestivalList = searchCulturalFestivalController.searchByKeyWord(keyWord.getText());
            ObservableList<CulturalFestival> culturalFestivalObservableList = FXCollections.observableList(culturalFestivalList);
            listResult.setItems(culturalFestivalObservableList);
        } else if (searchType == SearchType.HISTORICAL_FIGURE) {
            SearchHistoricalFigureController searchHistoricalFigureController = new SearchHistoricalFigureController();
            List<HistoricalFigure> historicalFigureList = searchHistoricalFigureController.searchByKeyWord(keyWord.getText());
            ObservableList<HistoricalFigure> historicalFigureObservableList = FXCollections.observableList(historicalFigureList);
            listResult.setItems(historicalFigureObservableList);
        } else if (searchType == SearchType.HISTORIC_EVENT) {
            SearchHistoricEventController searchHistoricEventController = new SearchHistoricEventController();
            List<HistoricEvent> historicEventList = searchHistoricEventController.searchByKeyWord(keyWord.getText());
            ObservableList<HistoricEvent> historicEventObservableList = FXCollections.observableList(historicEventList);
            listResult.setItems(historicEventObservableList);
        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Lưu ý");
            alert.setContentText("Hãy chọn thể loại cần tìm kiếm");
            alert.show();
        }
    }
    @FXML
    public void detail(ActionEvent event ) throws IOException {

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();

        // Historical Dynasty Detail
        if (searchType == SearchType.HISTORICAL_DYNASTY) {
            loader.setLocation(getClass().getResource("/searchscene/HistoricalDynastyScene.fxml"));
            Parent historicalDynastyScene = loader.load();
            Scene scene = new Scene(historicalDynastyScene);
            HistoricalDynastySceneController historicalDynastySceneController = loader.getController();
            HistoricalDynasty selected = (HistoricalDynasty) listResult.getSelectionModel().getSelectedItem();
            historicalDynastySceneController.setHistoricalDynasty(selected);
            stage.setScene(scene);
        } else if (searchType == SearchType.CULTURAL_FESTIVAL) {
            loader.setLocation(getClass().getResource("/searchscene/CulturalFestivalScene.fxml"));
            Parent culturalFestivalScene = loader.load();
            Scene scene = new Scene(culturalFestivalScene);
            CulturalFestivalSceneController culturalFestivalSceneController = loader.getController();
            CulturalFestival selected = (CulturalFestival) listResult.getSelectionModel().getSelectedItem();
            culturalFestivalSceneController.setCulturalFestival(selected);
            stage.setScene(scene);
        } else if (searchType == SearchType.HISTORICAL_SITE) {
            loader.setLocation(getClass().getResource("/searchscene/HistoricalSiteScene.fxml"));
            Parent culturalFestivalScene = loader.load();
            Scene scene = new Scene(culturalFestivalScene);
            HistoricalSiteSceneController historicalSiteSceneController = loader.getController();
            HistoricalSite selected = (HistoricalSite) listResult.getSelectionModel().getSelectedItem();
            historicalSiteSceneController.setHistoricalSite(selected);
            stage.setScene(scene);
        } else if (searchType == SearchType.HISTORICAL_FIGURE) {
            loader.setLocation(getClass().getResource("/searchscene/HistoricalFigureScene.fxml"));
            Parent culturalFestivalScene = loader.load();
            Scene scene = new Scene(culturalFestivalScene);
            HistoricalFigureSceneController historicalFigureSceneController = loader.getController();
            Dominator selected = (Dominator) listResult.getSelectionModel().getSelectedItem();
            historicalFigureSceneController.setHistoricalFigure(selected);
            stage.setScene(scene);
        } else if (searchType == SearchType.HISTORIC_EVENT) {
            loader.setLocation(getClass().getResource("/searchscene/HistoricEventScene.fxml"));
            Parent culturalFestivalScene = loader.load();
            Scene scene = new Scene(culturalFestivalScene);
            HistoricEventSceneController historicEventSceneController = loader.getController();
            WarEvent selected = (WarEvent) listResult.getSelectionModel().getSelectedItem();
            historicEventSceneController.setHistoricEvent(selected);
            stage.setScene(scene);
        }
    }

}