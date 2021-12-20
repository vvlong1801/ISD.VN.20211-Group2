package ecobikerental.capstone_project.controller;

import java.sql.SQLException;

import ecobikerental.capstone_project.entity.bike.Bike;

public class RentBikeController extends BaseController {
    public static Bike bike;

    /**
     * this method get bike info by Barcode.
     *
     * @param barcode - barcode of the bike
     *
     * @return Bike information
     */
    public Bike getBikeByBarcode(final String barcode) throws SQLException {
        if (!validateBarcode(barcode)) {
            return null;
        }
        String bikeCode = convertBarcodeToBikeCode(barcode);
        return new Bike().getBikeByBikeCode(bikeCode);
    }

    /**
     * this method convert barcode to bike code.
     *
     * @return Bike code
     */
    private String convertBarcodeToBikeCode(final String barcode) {
        return "08036af2-d2c2-43ad-ade1-6ac7023e9288";
    }

    /**
     * this method validate format barcode.
     *
     * @param barcode - barcode of bike
     *
     * @return - true if format barcode is valid else false
     */
    public boolean validateBarcode(final String barcode) {
        if (barcode == null || barcode.length() != 13) {
            return false;
        }
        return barcode.matches("^[0-9]+");
    }

    /**
     * this method process confirm rent bike.
     */
    public void confirmRentBike() {

    }
//
//    /**
//     * this method is bike getter.
//     *
//     * @return Bike
//     */
//    public Bike getBike() {
//        return bike;
//    }
//
//    /**
//     * this method is bike setter.
//     *
//     * @param bike -
//     */
//    public void setBike(final Bike bike) {
//        RentBikeController.bike = bike;
//    }
}
