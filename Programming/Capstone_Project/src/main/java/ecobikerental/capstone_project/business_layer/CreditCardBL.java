package ecobikerental.capstone_project.business_layer;

import java.util.Calendar;

import ecobikerental.capstone_project.exception.InvalidCardException;

/**
 * This class processes businesses related to Credit Card
 */
public class CreditCardBL {
    /**
     * This method validates credit card information including expired date and security code
     * @param expDate - the expired date
     * @param cvvCode - the security code
     * @return true if credit card info is valid, false if not
     */
    public static boolean validateCreditCardInfo(final String expDate, final String cvvCode) {
        if (validateExpirationDate(expDate) && validateCvvCode(cvvCode)) {
            return true;
        }
        return false;
    }

    /**
     * This method validates expired date
     * Correct format: mm/yy
     * @param expDate - the expired date
     * @return true if the expired date is correct format, false if not
     */
    private static boolean validateExpirationDate(final String expDate) {
        if (expDate == null) {
            return false;
        }
        return expDate.matches("^(0[1-9]|1[0-2])\\/?([0-9]{2})$");
    }

    /**
     * This method validates the security code
     * The security code is 3-digit number
     * @param cvvCode - the security code
     * @return true if the security code is correct format, false if not
     */
    private static boolean validateCvvCode(final String cvvCode) {
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
    public static String getExpirationDate(String date) throws InvalidCardException {
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
