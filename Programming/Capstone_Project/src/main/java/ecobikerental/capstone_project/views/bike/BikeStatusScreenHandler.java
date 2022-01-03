package ecobikerental.capstone_project.views.bike;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import ecobikerental.capstone_project.controller.ReturnBikeController;
import ecobikerental.capstone_project.entity.bike.Bike;
import ecobikerental.capstone_project.entity.bike.ElectricBike;
import ecobikerental.capstone_project.entity.invoice.Invoice;
import ecobikerental.capstone_project.utils.Configs;
import ecobikerental.capstone_project.views.BaseScreenHandler;
import ecobikerental.capstone_project.views.return_bike.ReturnBikeScreenHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class BikeStatusScreenHandler extends BaseScreenHandler implements Initializable {
    public Label lbBike;
    public ImageView imgBike;
    public ProgressBar progressBarPin;
    public Label lbPin;
    public Label lbTime;
    public HBox pin;
    public Button btnReturn;
    public ImageView imgLogo;

    private Bike bike;

    /**
     * This method is constructor with current stage.
     *
     * @param stage      -
     * @param screenPath -
     *
     * @throws IOException
     */
    public BikeStatusScreenHandler(Stage stage, String screenPath) throws IOException {
        super(stage, screenPath);
        this.bike = Invoice.getInstance().getBike();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setImage(imgLogo, Configs.LOGO_IMG_PATH);
        setImage(imgBike, Configs.BIKE_RUNNING_IMG_PATH);

        btnReturn.setOnMouseClicked(mouseEvent -> {
            try {
                requestToReturnBike();
            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }
        });
    }

    public void requestToReturnBike() throws IOException, SQLException {
        Invoice.getInstance().setRentalTime(lbTime.getText());
        ReturnBikeScreenHandler returnBikeScreen =
            new ReturnBikeScreenHandler(this.stage, Configs.RETURN_BIKE_SCREEN_PATH);
        returnBikeScreen.setScreenTitle("Return Bike Screen");
        returnBikeScreen.setController(this.getController());
        returnBikeScreen.setInfo();
        returnBikeScreen.setPrev(this);
        returnBikeScreen.show();
    }

    public void setInfo() {
        lbBike.setText(this.bike.getType() + " is running");
        if (this.bike.getType().equals("Standard e-bike")) {
            ElectricBike eBike = (ElectricBike) this.bike;
            progressBarPin.setVisible(true);
            pin.setVisible(true);
            lbPin.setText(eBike.getPin() + "%");
        }
    }

    /**
     * @return - {@link ReturnBikeController}
     */
    public ReturnBikeController getController() {
        return (ReturnBikeController) super.getController();
    }
}
