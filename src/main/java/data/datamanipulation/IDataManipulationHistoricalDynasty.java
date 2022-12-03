package data.datamanipulation;


import entity.HistoricalDynasty;

import java.util.List;

public interface IDataManipulationHistoricalDynasty {
    public void insertDataHistoricalDynasties(List<HistoricalDynasty> historicalDynasties);
    public List<HistoricalDynasty> getDataHistoricalDynasties();
}
