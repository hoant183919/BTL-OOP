package data.datamanipulation;


import entity.HistoricalDynasty;

import java.util.List;

public interface IDataManipulationHistoricalDynasty extends IDataManipulation{
    public void insertDataHistoricalDynasties(String url, List<HistoricalDynasty> historicalDynasties);
    public List<HistoricalDynasty> getDataHistoricalDynasties(String url);
}
