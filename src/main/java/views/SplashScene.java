package views;

import dataprocessingcontroller.DataSingleton;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utils.configs.ConfigResourceFXML;

public class SplashScene extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        DataSingleton.getInstance();
        Parent root = FXMLLoader.load(getClass().getResource((ConfigResourceFXML.SPLASH_SCENE_PATH)));
        Scene splashScene = new Scene(root);
        primaryStage.setScene(splashScene);
        primaryStage.setTitle("Tra cứu lịch sử Việt Nam");
        primaryStage.show();
    }
}