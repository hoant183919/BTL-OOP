import common.exception.HistoricEventDataCollectionException;
import datacollectioncontroller.datacollectioncontrollerimpl.DataCollectionNguoiKeSuController;
import datacollectioncontroller.datacollectioncontrollerimpl.DataCollectionWikipediaController;
import datamanipulation.datamanipulationimpl.DataManipulationHistoricalFigure;
import dataprocessingcontroller.BaseController;
import dataprocessingcontroller.SummaryController;
import entity.*;
import javafx.collections.ObservableList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import utils.Utils;
import utils.configs.ConfigDataType;
import utils.configs.ConfigResourceData;
import views.SplashScene;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Application extends SplashScene {

    public static void main(String[] args) throws IOException, HistoricEventDataCollectionException {
//        launch(args);
        DataCollectionWikipediaController dataCollectionWikipediaController = new DataCollectionWikipediaController();
        dataCollectionWikipediaController.collectionDataHistoricEvent();

    }
}
