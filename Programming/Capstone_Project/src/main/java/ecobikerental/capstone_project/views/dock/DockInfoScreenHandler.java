package ecobikerental.capstone_project.views.dock;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ecobikerental.capstone_project.entity.dock.Dock;
import ecobikerental.capstone_project.utils.Configs;
import ecobikerental.capstone_project.views.BaseScreenHandler;
import ecobikerental.capstone_project.views.home.HomeScreenHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class DockInfoScreenHandler extends BaseScreenHandler implements Initializable {
    public ImageView imgDock;
    public ImageView imgLogo;
    public Label lbName;
    public Label lbAddress;
    public Label lbArea;
    public Label lbQuantity;
    public TextField tfBarcode;
    public Button btnViewBike;
    public Button btnBack;

    public DockInfoScreenHandler(Stage stage, String screenPath) throws IOException {
        super(stage, screenPath);
    }

    public void setInfo(Dock dock){
        lbName.setText(dock.getDockName());
        lbAddress.setText(dock.getAddress());
        lbArea.setText(String.valueOf(dock.getArea()+"km2"));
        lbQuantity.setText(String.valueOf(dock.getQuantity()));
        setImage(imgDock,"assets/images/dock2.jpg");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        btnBack.setOnAction(event->{
            this.getPrev().show();
        });

        setImage(imgLogo, Configs.LOGO_IMG_PATH);
        imgLogo.setOnMouseClicked(mouseEvent->{
            try {
                new HomeScreenHandler(this.stage, Configs.HOME_SCREEN_PATH).show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }
}
