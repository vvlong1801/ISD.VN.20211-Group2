package ecobikerental.capstone_project.views.paydeposit;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ecobikerental.capstone_project.controller.PayBikeDepositController;
import ecobikerental.capstone_project.controller.RentBikeController;
import ecobikerental.capstone_project.entity.payment.CreditCard;
import ecobikerental.capstone_project.views.BaseScreenHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ConfirmDepositScreenHandler extends BaseScreenHandler implements Initializable {
    public Label lbCardholderName;
    public Label lbCardNumber;
    public Label lbIssuingBank;
    public Label lbExpDate;
    public Label lbAmount;
    public Label lbContent;
    public Button btnBack;
    public Button btnConfirm;
    public ImageView imgLogo;

    /**
     * This method is constructor with current stage.
     *
     * @param stage      -
     * @param screenPath -
     *
     * @throws IOException
     */
    public ConfirmDepositScreenHandler(Stage stage, String screenPath) throws IOException {
        super(stage, screenPath);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btnConfirm.setOnAction(event -> {
            confirmPayDeposit();
        });
    }

    private void confirmPayDeposit() {
        this.getController().payDeposit(RentBikeController.bike.getDeposit(), lbContent.getText(), lbCardNumber.getText(),
                lbCardholderName.getText(),lbExpDate.getText(),"774");
    }

    public void displayInfo(String cardCode, String owner, String dateExp, String content) {
        this.lbCardholderName.setText(owner);
        this.lbCardNumber.setText(cardCode);
        this.lbExpDate.setText(dateExp);
        this.lbContent.setText(content);
        this.lbAmount.setText(String.valueOf(RentBikeController.bike.getDeposit()));
    }

    public PayBikeDepositController getController() {
        return (PayBikeDepositController) super.getController();
    }
}
