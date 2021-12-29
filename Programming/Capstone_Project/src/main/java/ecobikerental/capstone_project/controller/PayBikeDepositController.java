package ecobikerental.capstone_project.controller;

import java.util.Calendar;
import java.util.Hashtable;
import java.util.Map;

import ecobikerental.capstone_project.entity.payment.CreditCard;
import ecobikerental.capstone_project.entity.payment.PaymentTransaction;
import ecobikerental.capstone_project.exception.InvalidCardException;
import ecobikerental.capstone_project.exception.PaymentException;
import ecobikerental.capstone_project.exception.UnrecognizedException;
import ecobikerental.capstone_project.subsystem.InterbankInterface;
import ecobikerental.capstone_project.subsystem.InterbankSubsystem;

public class PayBikeDepositController extends BaseController {
    private CreditCard card;
    private PaymentTransaction paymentTransaction;
    private InterbankInterface interbank;

        public boolean validateCreditCardInfo(final String expDate, final String cvvCode) {
            if (validateExpirationDate(expDate) && validateCvvCode(cvvCode)) {
                return true;
            }
            return false;
        }

        public boolean validateExpirationDate(final String expDate) {
            if (expDate == null) {
                return false;
            }
            return expDate.matches("^(0[1-9]|1[0-2])\\/?([0-9]{2})$");
        }

        public boolean validateCvvCode(final String cvvCode) {
            if (cvvCode == null || cvvCode.length() != 3) {
                return false;
            }
            return cvvCode.matches("^[0-9]{3}$");
        }

    /**
     * Validate the input date which should be in the format "mm/yy", and then
     * return a {@link java.lang.String String} representing the date in the
     * required format "mmyy" .
     *
     * @param date - the {@link java.lang.String String} represents the input date
     *
     * @return {@link java.lang.String String} - date representation of the required
     * format
     *
     * @throws InvalidCardException - if the string does not represent a valid date
     *                              in the expected format
     */
    private String getExpirationDate(String date) throws InvalidCardException {
        String[] strs = date.split("/");
        if (strs.length != 2) {
            throw new InvalidCardException();
        }

        String expirationDate = null;
        int month = -1;
        int year = -1;

        try {
            month = Integer.parseInt(strs[0]);
            year = Integer.parseInt(strs[1]);
            if (month < 1 || month > 12 || year < Calendar.getInstance().get(Calendar.YEAR) % 100 || year > 100) {
                throw new InvalidCardException();
            }
            expirationDate = strs[0] + strs[1];

        } catch (Exception ex) {
            throw new InvalidCardException();
        }

        return expirationDate;
    }

    /**
     * this method pay deposit for the bike.
     *
     * @param amount         -
     * @param contents       -
     * @param cardNumber     -
     * @param cardHolderName -
     * @param expirationDate -
     * @param securityCode   -
     *
     * @return Map<String, String> contain result pay Deposit with message
     */
    public Map<String, String> payDeposit(int amount, String contents, String cardNumber, String cardHolderName,
                                          String expirationDate, String securityCode) {
        Map<String, String> result = new Hashtable<String, String>();
        result.put("RESULT", "PAYMENT FAILED!");
        try {
            this.card = new CreditCard(cardNumber, cardHolderName, securityCode,
                getExpirationDate(expirationDate));

            this.interbank = new InterbankSubsystem();
            PaymentTransaction transaction = interbank.payDeposit(card, amount, contents);

            result.put("RESULT", "PAYMENT SUCCESSFUL!");
            result.put("MESSAGE", "You have successfully paid the order!");
        } catch (PaymentException | UnrecognizedException ex) {
            result.put("MESSAGE", ex.getMessage());
        }
        return result;
    }

    /**
     * this method refund deposit fee after calculate rental fee.
     *
     * @return Map contain result refund with message.
     */
    public Map<String, String> refund() {
        return null;
    }
}
