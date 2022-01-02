package ecobikerental.capstone_project.business_layer;

import ecobikerental.capstone_project.utils.Utils;

public class BikeBL {
    /**
     * this method validate format barcode.
     *
     * @param barcode - barcode of bike
     *
     * @return - true if format barcode is valid else false
     */
    public static boolean validateBarcode(final String barcode) {
        if (barcode == null || barcode.length() != 13) {
            return false;
        }
        return barcode.matches("^[0-9]+");
    }

    /**
     * @param barcode -
     *
     * @return String: bike code
     */
    public static String convertBarcodeToBikeCode(final String barcode) {
        if (!validateBarcode(barcode)) {
            return null;
        }
        return barcode + "123456" + barcode;
    }


}
