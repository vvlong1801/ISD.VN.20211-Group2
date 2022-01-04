package ecobikerental.capstone_project.views.bike;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ecobikerental.capstone_project.controller.PayBikeDepositController;
import ecobikerental.capstone_project.controller.RentBikeController;
import ecobikerental.capstone_project.entity.bike.Bike;
import ecobikerental.capstone_project.entity.bike.ElectricBike;
import ecobikerental.capstone_project.entity.invoice.Invoice;
import ecobikerental.capstone_project.utils.Configs;
import ecobikerental.capstone_project.utils.Utils;
import ecobikerental.capstone_project.views.BaseScreenHandler;
import ecobikerental.capstone_project.views.paydeposit.PayDepositScreenHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class BikeInfoScreenHandler extends BaseScreenHandler implements Initializable {
    public ImageView imgBike;
    public Label lbType;
    public Label lbBarcode;
    public Label lbLicensePlate;
    public Label lbDockName;
    public Label lbDeposit;
    public Label lbPin;
    public HBox licensePlate;
    public HBox pin;
    public Button btnBack;
    public Button btnRent;
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
    public BikeInfoScreenHandler(Stage stage, String screenPath) throws IOException {
        super(stage, screenPath);
    }

    /**
     * this method set info of screen.
     */
    public void setInfo() {
        this.lbBarcode.setText(this.bike.getBarcode());
        this.lbDockName.setText(this.bike.getDockName());
        this.lbDeposit.setText(Utils.getCurrencyFormat(this.bike.getDeposit()));
        this.lbType.setText(this.bike.getType());
        if (this.bike.getType().equals("Standard e-bike")) {
            ElectricBike electricBike = (ElectricBike) this.bike;
            pin.setVisible(true);
            licensePlate.setVisible(true);
            lbLicensePlate.setText(electricBike.getLicensePlate());
            lbPin.setText(electricBike.getPin() + "%");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.setImage(imgLogo, Configs.LOGO_IMG_PATH);
        this.setImage(imgBike, "assets/images/e-bike.jpg");

        btnRent.setOnAction(event -> {
            try {
                confirmRentBike();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        btnBack.setOnMouseClicked(mouseEvent -> {
            this.getPrev().show();
        });
    }

    public void confirmRentBike() throws IOException {
        Invoice.getInstance().setBike(this.bike);

        PayDepositScreenHandler payDepositScreen =
            new PayDepositScreenHandler(this.stage, Configs.PAY_DEPOSIT_SCREEN_PATH);

        payDepositScreen.setScreenTitle("Pay Deposit Screen");
        payDepositScreen.setController(new PayBikeDepositController());
        payDepositScreen.setPrev(this);

        payDepositScreen.show();

    }

    public void setBike(Bike bike) {
        this.bike = bike;
    }

    public RentBikeController getController() {
        return (RentBikeController) super.getController();
    }
}
