package ecobikerental.capstone_project.controller;

import java.sql.SQLException;
import java.util.Hashtable;
import java.util.Map;

import ecobikerental.capstone_project.business_layer.CreditCardBL;
import ecobikerental.capstone_project.dbconnnection_layer.BikeDL;
import ecobikerental.capstone_project.dbconnnection_layer.PaymentTransactionDL;
import ecobikerental.capstone_project.entity.invoice.Invoice;
import ecobikerental.capstone_project.entity.payment.CreditCard;
import ecobikerental.capstone_project.entity.payment.PaymentTransaction;
import ecobikerental.capstone_project.exception.PaymentException;
import ecobikerental.capstone_project.exception.UnrecognizedException;
import ecobikerental.capstone_project.subsystem.InterbankInterface;
import ecobikerental.capstone_project.subsystem.InterbankSubsystem;

public class PayBikeDepositController extends BaseController {
    private InterbankInterface interbank;

    public boolean checkCardInfo(String expDate, String cvvCode) {
        return CreditCardBL.validateCreditCardInfo(expDate, cvvCode);
    }

    /**
     * @param card     -
     * @param amount   -
     * @param contents -
     *
     * @return
     */
    public Map<String, String> payDeposit(CreditCard card, int amount, String contents) {
        Map<String, String> result = new Hashtable<String, String>();
        result.put("RESULT", "PAYMENT FAILED!");
        try {
            card.setDateExpired(CreditCardBL.getExpirationDate(card.getDateExpired()));
            this.interbank = new InterbankSubsystem();

            PaymentTransaction transaction = interbank.payDeposit(card, amount, contents);
            Invoice.getInstance().setPayDepositTransaction(transaction);
            new BikeDL().updateBike(Invoice.getInstance().getBike().getBikeCode(),null);
            PaymentTransactionDL.save(transaction);
            result.put("RESULT", "PAYMENT SUCCESSFUL!");
            result.put("MESSAGE", "You have successfully paid the bike of deposit!");
        } catch (PaymentException | UnrecognizedException | SQLException ex) {
            result.put("MESSAGE", ex.getMessage());
        }

        return result;
    }
}
