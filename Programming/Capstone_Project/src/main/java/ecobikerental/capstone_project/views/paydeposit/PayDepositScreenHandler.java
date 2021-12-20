package ecobikerental.capstone_project.views.paydeposit;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ecobikerental.capstone_project.controller.PayBikeDepositController;
import ecobikerental.capstone_project.entity.payment.CreditCard;
import ecobikerental.capstone_project.utils.Configs;
import ecobikerental.capstone_project.views.BaseScreenHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class PayDepositScreenHandler extends BaseScreenHandler implements Initializable {
    public TextField tfCardholderName;
    public TextField tfCardNumber;
    public ComboBox<String> cbbIssuingBank;
    public TextField tfSecurityCode;
    public TextField tfExpirationDate;
    public TextArea taContent;
    public Button btnBack;
    public Button btnContinue;
    public ImageView imgLogo;

    /**
     * This method is constructor with current stage.
     *
     * @param stage      -
     * @param screenPath -
     *
     * @throws IOException
     */
    public PayDepositScreenHandler(Stage stage, String screenPath) throws IOException {
        super(stage, screenPath);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btnContinue.setOnAction(event -> {
            try {
                requestToPayDeposit();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }


    /**
     * this method get controller.
     *
     * @return PayBikeDepositController
     */
    public PayBikeDepositController getController() {
        return (PayBikeDepositController) super.getController();
    }

    public void requestToPayDeposit() throws IOException {
        String owner = tfCardholderName.getText();
        String cardCode = tfCardNumber.getText();
        String cvvCode = tfSecurityCode.getText();
        String expDate = tfExpirationDate.getText();
        String content = taContent.getText();

        if (this.getController().validateCreditCardInfo(expDate, cvvCode)) {
            ConfirmDepositScreenHandler confirmDepositScreen =
                new ConfirmDepositScreenHandler(this.stage, Configs.DEPOSIT_CONFIRM_SCREEN_PATH);
            confirmDepositScreen.displayInfo(owner, cardCode, expDate, content);
            confirmDepositScreen.setPrev(this);
            confirmDepositScreen.setController(this.getController());
            confirmDepositScreen.setScreenTitle("Confirm Pay Deposit");
            confirmDepositScreen.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Card invalid format!!");
            alert.setContentText("Expired Date has format mm/yy\nLength of security code is 3\nPlease enter again!!");
            alert.showAndWait();
        }
    }
    //    public void requestToPayBikeDeposit(int depositFees) throws IOException {
    //
    //    }


}
