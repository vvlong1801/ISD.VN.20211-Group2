package ecobikerental.capstone_project.views;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SplashScreenHandler implements Initializable {

    public ImageView logo;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File file = new File("assets/images/Splash.jpg");
        Image image = new Image(file.toURI().toString());
        logo.setImage(image);
    }
}
