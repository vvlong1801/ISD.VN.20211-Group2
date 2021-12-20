package ecobikerental.capstone_project.views.dock;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import ecobikerental.capstone_project.controller.RentBikeController;
import ecobikerental.capstone_project.entity.bike.Bike;
import ecobikerental.capstone_project.entity.dock.Dock;
import ecobikerental.capstone_project.utils.Configs;
import ecobikerental.capstone_project.views.BaseScreenHandler;
import ecobikerental.capstone_project.views.bike.BikeInfoScreenHandler;
import ecobikerental.capstone_project.views.home.HomeScreenHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
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

    /**
     * This method set info of selected dock to display on screen.
     *
     * @param dock -
     */
    public void setInfo(Dock dock) {
        lbName.setText(dock.getDockName());
        lbAddress.setText(dock.getAddress());
        lbArea.setText(String.valueOf(dock.getArea() + "km2"));
        lbQuantity.setText(String.valueOf(dock.getQuantity()));
        setImage(imgDock, "assets/images/dock2.jpg");
    }

    /**
     * @return HomeController
     */
    public RentBikeController getController() {
        return (RentBikeController) super.getController();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setController(new RentBikeController());
        //        setController(new HomeController());
        setImage(imgLogo, Configs.LOGO_IMG_PATH);

        btnBack.setOnAction(event -> {
            this.getPrev().show();
        });

        imgLogo.setOnMouseClicked(mouseEvent -> {
            try {
                new HomeScreenHandler(this.stage, Configs.HOME_SCREEN_PATH).show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        btnViewBike.setOnAction(event -> {
            viewBike();
        });

    }

    public void viewBike() {
        System.out.println("clickeddddd");
        String barcode = tfBarcode.getText();

        Bike bike = null;
        try {
            bike = this.getController().getBikeByBarcode(barcode);
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("The bike with barcode " + barcode + " could not found");
            alert.setContentText("Please re-enter the barcode!!");
            alert.showAndWait();
        }

        if (bike == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("" + barcode + " invalid");
            alert.setContentText("Please re-enter the barcode!!");
            alert.showAndWait();
        } else {
            BikeInfoScreenHandler bikeScreen = null;
            try {
                bikeScreen = new BikeInfoScreenHandler(this.stage, Configs.BIKE_INFO_SCREEN_PATH);
                bikeScreen.setBike(bike);
                bikeScreen.displayInfo(barcode);
                bikeScreen.setController(this.getController());
                bikeScreen.setPrev(this);
                bikeScreen.setScreenTitle("Bike Screen");
                bikeScreen.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
