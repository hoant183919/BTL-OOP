package views;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import views.datasummaryscene.DataSummarySceneController;

import java.io.IOException;

public class SplashScene extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource(("/SplashScene.fxml")));
        Scene splashScene = new Scene(root);
        primaryStage.setScene(splashScene);
        primaryStage.setTitle("Tra cuu lich su");
        primaryStage.show();
    }
}
