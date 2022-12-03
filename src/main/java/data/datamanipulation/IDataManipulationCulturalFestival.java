package data.datamanipulation;

import entity.CulturalFestival;

import java.util.List;

public interface IDataManipulationCulturalFestival {
    public void insertDataCulturalFestivals(String url, List<CulturalFestival> culturalFestivalList);
    public List<CulturalFestival> getDataCulturalFestivals(String url);
}
