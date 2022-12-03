package main.java.data.datamanipulation;

import main.java.entity.HistoricalSite;

import java.util.List;

public interface IDataManipulationHistoricalSite {
    public void insertDataHistoricalSites(List<HistoricalSite> historicalSites);
    public List<HistoricalSite> getDataHistoricalSites();
}
