package main.java.data.datamanipulation;

import main.java.entity.HistoricalFigure;

import java.util.List;

public interface IDataManipulationHistoricalFigure {
    public void insertDataHistoricalFigures(List<HistoricalFigure> historicalFigures);
    public List<HistoricalFigure> getDataHistoricalFigures();
}
