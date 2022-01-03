package ecobikerental.capstone_project.views.invoice;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ecobikerental.capstone_project.controller.ViewDockController;
import ecobikerental.capstone_project.entity.invoice.Invoice;
import ecobikerental.capstone_project.utils.Configs;
import ecobikerental.capstone_project.utils.Utils;
import ecobikerental.capstone_project.views.BaseScreenHandler;
import ecobikerental.capstone_project.views.home.HomeScreenHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class InvoiceScreenHandler extends BaseScreenHandler implements Initializable {

    public Label lbRenter;
    public Label lbCardNumber;
    public Label lbDeposit;
    public Label lbRefund;
    public Label lbBikeBarcode;
    public Button btnReturnHome;
    public ImageView imgLogo;
    public Label lbRentaLFees;

    /**
     * This method is constructor with current stage.
     *
     * @param stage      -
     * @param screenPath -
     *
     * @throws IOException
     */
    public InvoiceScreenHandler(Stage stage, String screenPath) throws IOException {
        super(stage, screenPath);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setImage(imgLogo, Configs.LOGO_IMG_PATH);

        btnReturnHome.setOnMouseClicked(mouseEvent -> {
            HomeScreenHandler homeScreenHandler = null;
            try {
                homeScreenHandler = new HomeScreenHandler(this.stage, Configs.HOME_SCREEN_PATH);
                homeScreenHandler.setController(new ViewDockController());
                homeScreenHandler.setScreenTitle("Home Screen");
                homeScreenHandler.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public void setInfo() {
        lbBikeBarcode.setText(Invoice.getInstance().getBike().getBarcode());
        lbCardNumber.setText(Invoice.getInstance().getPayDepositTransaction().getCard().getCardCode());
        lbBikeBarcode.setText(Invoice.getInstance().getBike().getBarcode());
        lbDeposit.setText(Utils.getCurrencyFormat(Invoice.getInstance().getBike().getDeposit()));
        lbRenter.setText(Invoice.getInstance().getPayDepositTransaction().getCard().getOwner());
        lbRefund.setText(Utils.getCurrencyFormat(Invoice.getInstance().getRefundTransaction().getAmount()));
        lbRentaLFees.setText(Utils.getCurrencyFormat(Invoice.getInstance().getRentalFee()));
    }
}
