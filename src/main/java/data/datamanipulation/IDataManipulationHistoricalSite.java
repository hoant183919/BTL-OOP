package data.datamanipulation;

import entity.HistoricalSite;

import java.util.List;

public interface IDataManipulationHistoricalSite {
    public void insertDataHistoricalSites(List<HistoricalSite> historicalSites);
    public List<HistoricalSite> getDataHistoricalSites();
}
