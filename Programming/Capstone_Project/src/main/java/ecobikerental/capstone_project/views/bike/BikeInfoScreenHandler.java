package ecobikerental.capstone_project.views.bike;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ecobikerental.capstone_project.controller.PayBikeDepositController;
import ecobikerental.capstone_project.controller.RentBikeController;
import ecobikerental.capstone_project.entity.bike.Bike;
import ecobikerental.capstone_project.utils.Configs;
import ecobikerental.capstone_project.views.BaseScreenHandler;
import ecobikerental.capstone_project.views.paydeposit.PayDepositScreenHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class BikeInfoScreenHandler extends BaseScreenHandler implements Initializable {
    public ImageView imgBike;
    public Label lbType;
    public Label lbBarcode;
    public Label lbLicensePlate;
    public Label lbDockName;
    public Label lbDeposit;
    public RadioButton rbCreditCard;
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
     *
     * @param bike    - the bike that is displayed information.
     * @param barcode - barcode of bike.
     */
    public void displayInfo(final String barcode) {
        this.lbBarcode.setText(barcode);
        this.lbLicensePlate.setText(this.bike.getLicensePlate());
        this.lbDockName.setText(this.bike.getDockName());
        this.lbDeposit.setText("" + this.bike.getDeposit());
        this.lbType.setText(this.bike.getType());
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
    }

    public void confirmRentBike() throws IOException {
        PayDepositScreenHandler payDepositScreen =
            new PayDepositScreenHandler(this.stage, Configs.PAY_DEPOSIT_SCREEN_PATH);

        payDepositScreen.setScreenTitle("Pay Deposit Screen");
        payDepositScreen.setController(new PayBikeDepositController());
        payDepositScreen.setPrev(this);

        payDepositScreen.show();

    }

//    public Bike getBike() {
//        return bike;
//    }

    public void setBike(Bike bike) {
        this.bike = bike;
        RentBikeController.bike = this.bike;
    }

    public RentBikeController getController() {
        return (RentBikeController) super.getController();
    }
}
