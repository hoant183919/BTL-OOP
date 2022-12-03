import controller.datacollectioncontroller.DataCollectionController;

import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException {
        DataCollectionController dataCollectionController = new DataCollectionController();
        dataCollectionController.collectData();
    }
}
