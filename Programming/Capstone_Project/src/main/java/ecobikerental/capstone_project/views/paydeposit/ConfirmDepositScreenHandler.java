package ecobikerental.capstone_project.views.paydeposit;

import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

import com.mysql.cj.util.Util;
import ecobikerental.capstone_project.controller.ReturnBikeController;
import ecobikerental.capstone_project.controller.PayBikeDepositController;
import ecobikerental.capstone_project.controller.RentBikeController;
import ecobikerental.capstone_project.entity.invoice.Invoice;
import ecobikerental.capstone_project.entity.payment.CreditCard;
import ecobikerental.capstone_project.utils.Configs;
import ecobikerental.capstone_project.utils.Utils;
import ecobikerental.capstone_project.views.BaseScreenHandler;
import ecobikerental.capstone_project.views.bike.BikeStatusScreenHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ConfirmDepositScreenHandler extends BaseScreenHandler implements Initializable {
    public Label lbCardholderName;
    public Label lbCardNumber;
    public Label lbExpDate;
    public Label lbAmount;
    public Label lbContent;
    public Button btnBack;
    public Button btnConfirm;
    public ImageView imgLogo;

    private CreditCard card;
    private String content;

    /**
     * This method is constructor with current stage.
     *
     * @param stage      -
     * @param screenPath -
     *
     * @throws IOException
     */
    public ConfirmDepositScreenHandler(Stage stage, String screenPath, CreditCard card, String content)
        throws IOException {
        super(stage, screenPath);
        this.card = card;
        this.content = content;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setImage(imgLogo, Configs.LOGO_IMG_PATH);
        btnConfirm.setOnAction(event -> {
            try {
                confirmPayDeposit();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        btnBack.setOnMouseClicked(mouseEvent -> {
            this.getPrev().show();
        });
    }

    private void confirmPayDeposit() throws IOException {
        Map<String, String> result =
            this.getController().payDeposit(card, Invoice.getInstance().getBike().getDeposit(), content);

        if (result.get("RESULT").equals("PAYMENT SUCCESSFUL!")) {
            // popup notify pay deposit is successful
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle(result.get("RESULT"));
            alert.setContentText(result.get("MESSAGE"));
            alert.showAndWait();

            BikeStatusScreenHandler bikeStatusScreen =
                new BikeStatusScreenHandler(this.stage, Configs.BIKE_STATUS_SCREEN_PATH);
            bikeStatusScreen.setController(new ReturnBikeController());
            bikeStatusScreen.setInfo();
            bikeStatusScreen.setScreenTitle("Bike Status");
            bikeStatusScreen.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle(result.get("RESULT"));
            alert.setContentText(result.get("MESSAGE"));
            alert.showAndWait();
        }
    }

    public void setInfo() {
        this.lbCardholderName.setText(this.card.getOwner());
        this.lbCardNumber.setText(this.card.getCardCode());
        this.lbExpDate.setText(this.card.getDateExpired());
        this.lbContent.setText(this.content);
        this.lbAmount.setText(Utils.getCurrencyFormat(Invoice.getInstance().getBike().getDeposit()));
    }

    public PayBikeDepositController getController() {
        return (PayBikeDepositController) super.getController();
    }
}
