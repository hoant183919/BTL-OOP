package datacollectioncontroller;

import common.exception.CulturalFestivalDataCollectionException;
import entity.CulturalFestival;

import java.io.IOException;
import java.util.List;

public interface IDataCollectionCulturalFestivalController {

    /**
     * Thu thập dữ liệu về các lễ hội Việt Nam
     * @return Danh sách các lễ hội
     * @throws IOException
     * @throws CulturalFestivalDataCollectionException
     */
    public List<CulturalFestival> collectionDataCulturalFestival() throws IOException, CulturalFestivalDataCollectionException;
}
