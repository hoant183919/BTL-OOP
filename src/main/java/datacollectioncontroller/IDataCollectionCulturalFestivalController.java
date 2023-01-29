package datacollectioncontroller;

import common.exception.CulturalFestivalDataCollectionException;
import entity.CulturalFestival;

import java.io.IOException;
import java.util.List;

public interface IDataCollectionCulturalFestivalController {

    public List<CulturalFestival> collectionDataCulturalFestival() throws IOException, CulturalFestivalDataCollectionException;
}
