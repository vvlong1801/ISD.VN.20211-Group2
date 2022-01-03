package ecobikerental.capstone_project.business_layer;

import ecobikerental.capstone_project.utils.Utils;

/**
 * This class processes businesses related to Bike
 */
public class BikeBL {
    /**
     * This method validate format barcode
     * @param barcode - barcode of bike
     * @return - true if format barcode is correct else false
     */
    public static boolean validateBarcode(final String barcode) {
        if (barcode == null || barcode.length() != 13) {
            return false;
        }
        return barcode.matches("^[0-9]+");
    }

    /**
     * This method convert barcode to bike code
     * @param barcode - the barcode that user entered
     * @return String: bike code
     */
    public static String convertBarcodeToBikeCode(final String barcode) {
        if (!validateBarcode(barcode)) {
            return null;
        }
        return barcode + "123456" + barcode;
    }


}
