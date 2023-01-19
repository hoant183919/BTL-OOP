package datacollectioncontroller;

import entity.CulturalFestival;

import java.io.IOException;
import java.util.List;

public interface IDataCollectionCulturalFestivalController {

    public List<CulturalFestival> collectionDataCulturalFestival() throws IOException;
}
