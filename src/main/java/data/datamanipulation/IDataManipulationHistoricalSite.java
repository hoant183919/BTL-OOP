package data.datamanipulation;

import entity.HistoricalSite;

import java.util.List;

public interface IDataManipulationHistoricalSite{
    public void insertDataHistoricalSites(String url, List<HistoricalSite> historicalSites);
    public List<HistoricalSite> getDataHistoricalSites(String url);
}
