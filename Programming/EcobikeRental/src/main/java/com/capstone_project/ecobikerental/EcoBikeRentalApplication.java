package com.capstone_project.ecobikerental;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class EcoBikeRentalApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(EcoBikeRentalApplication.class.getResource("home.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("EcoBike Rental");
        stage.setScene(scene);
        System.out.println(getClass());
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}