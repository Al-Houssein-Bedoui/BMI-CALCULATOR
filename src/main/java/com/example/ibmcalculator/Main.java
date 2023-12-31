package com.example.ibmcalculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    private static Stage stg;

    @Override
    public void start(Stage stage) throws IOException {
        stg = stage;
        stage.setResizable(false);
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("ibm-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("IBM Calculator");
        stage.setScene(scene);
        stage.show();
    }
    public void changeScene( String FXML , String window) throws IOException {
        Parent pane =  FXMLLoader.load(getClass().getResource(FXML));
        stg.setTitle(window);
        stg.getScene().setRoot(pane);

    }
    public static void main(String[] args) {
        launch();
    }
}