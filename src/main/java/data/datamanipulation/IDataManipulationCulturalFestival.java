package data.datamanipulation;

import entity.CulturalFestival;

import java.util.List;

public interface IDataManipulationCulturalFestival {
    public void insertDataCulturalFestivals(List<CulturalFestival> culturalFestivalList);
    public List<CulturalFestival> getDataCulturalFestivals();
}
