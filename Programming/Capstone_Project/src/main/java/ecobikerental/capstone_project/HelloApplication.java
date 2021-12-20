package ecobikerental.capstone_project;

import ecobikerental.capstone_project.utils.Configs;
import ecobikerental.capstone_project.views.home.HomeScreenHandler;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        StackPane root = (StackPane) FXMLLoader.load(getClass().getResource("views/splash.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        // Load splash screen with fade in effect
        FadeTransition fadeIn = new FadeTransition(Duration.seconds(2), root);
        fadeIn.setFromValue(0);
        fadeIn.setToValue(1);
        fadeIn.setCycleCount(1);

        // Finish splash with fade out effect
        FadeTransition fadeOut = new FadeTransition(Duration.seconds(1), root);
        fadeOut.setFromValue(1);
        fadeOut.setToValue(0);
        fadeOut.setCycleCount(1);

        // After fade in, start fade out
        fadeIn.play();
        fadeIn.setOnFinished((e) -> {
            fadeOut.play();
        });

        fadeOut.setOnFinished(event -> {
            try {
                HomeScreenHandler homeHandler = new HomeScreenHandler(stage, Configs.HOME_SCREEN_PATH);
                homeHandler.setScreenTitle("Home Screen");
                homeHandler.show();
            } catch (IOException e) {
                e.printStackTrace();
            }

        });
        //        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("views/home.fxml"));
        //        fxmlLoader.setController(new HomeScreenHandler());
        //        Scene scene = new Scene(fxmlLoader.load());
        //        stage.setTitle("Hello!");
        //        stage.setScene(scene);
        //        stage.show();
        //        HomeScreenHandler homeScreenHandler = new HomeScreenHandler(stage,"views/home.fxml");
        //        homeScreenHandler.setSceneTitle("Home Screen");
        //        homeScreenHandler.show();
    }

    public static void main(String[] args) {
        launch();
    }
}