package controller;

import commom.exception.InvalidCardException;

import java.util.Calendar;

public class PayBikeDepositController extends BaseController {

    public boolean validateCreditCardInfo(){
        return false;
    }

    public boolean validateExpirationDate(String expDate){
        if (expDate==null) return false;
        return expDate.matches("^(0[1-9]|1[0-2])\\/?([0-9]{2})$");
    }

    public boolean validateCvvCode(String cvvCode){
        if (cvvCode == null || cvvCode.length()!=3) return false;
        return cvvCode.matches("^[0-9]{3}$");
    }
    /**
     * Validate the input date which should be in the format "mm/yy", and then
     * return a {@link java.lang.String String} representing the date in the
     * required format "mmyy" .
     *
     * @param date - the {@link java.lang.String String} represents the input date
     * @return {@link java.lang.String String} - date representation of the required
     *         format
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
}
