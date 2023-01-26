package dataprocessingcontroller;

import entity.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SummaryController extends BaseController{
    @Override
    public ObservableList<CulturalFestival> getAllCulturalFestival() {
        return FXCollections.observableList(super.getAllCulturalFestival());
    }
    @Override
    public ObservableList<HistoricalDynasty> getAllHistoricalDynasty() {
        return FXCollections.observableList(super.getAllHistoricalDynasty());
    }
    @Override
    public ObservableList<HistoricalFigure> getAllHistoricalFigure() {
        return FXCollections.observableList(super.getAllHistoricalFigure());
    }
    @Override
    public ObservableList<HistoricEvent> getAllHistoricEvent() {
        return FXCollections.observableList(super.getAllHistoricEvent());
    }
    @Override
    public ObservableList<HistoricalSite> getAllHistoricalSite() {
        return FXCollections.observableList(super.getAllHistoricalSite());
    }
}
