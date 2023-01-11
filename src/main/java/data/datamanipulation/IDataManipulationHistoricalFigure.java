package data.datamanipulation;

import entity.HistoricalFigure;

import java.util.List;

public interface IDataManipulationHistoricalFigure extends IDataManipulation{
    public void insertDataHistoricalFigures(String url, List<HistoricalFigure> historicalFigures);
    public List<HistoricalFigure> getDataHistoricalFigures(String url);
}
