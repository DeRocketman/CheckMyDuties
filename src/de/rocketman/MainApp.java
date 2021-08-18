package de.rocketman;

import de.rocketman.view.CompareViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {

    private  Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Check my Duties");

        showCompareView();
    }

    private void showCompareView() throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/CompareView.fxml"));
            AnchorPane compareView = (AnchorPane) loader.load();

            rootLayout.setCenter(compareView);

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
