package main.java.data.datamanipulation;

import main.java.entity.CulturalFestival;

import java.util.List;

public interface IDataManipulationCulturalFestival {
    public void insertDataCulturalFestivals(List<CulturalFestival> culturalFestivalList);
    public List<CulturalFestival> getDataCulturalFestivals();
}
