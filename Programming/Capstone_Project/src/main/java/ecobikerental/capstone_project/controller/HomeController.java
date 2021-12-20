package ecobikerental.capstone_project.controller;

import java.sql.SQLException;
import java.util.List;

import ecobikerental.capstone_project.entity.bike.Bike;
import ecobikerental.capstone_project.entity.dock.Dock;

public class HomeController extends BaseController {
    /**
     * this method get the list of docks.
     * @return List of docks
     *
     * @throws SQLException
     */
    public List getDockList() throws SQLException {
        return new Dock().getDockList();
    }

    /**
     * this method get info dock by id.
     * @param name - letters in name of dock
     *
     * @return dock has letters of dock name like param
     *
     * @throws SQLException
     */
    public List searchDockByName(final String name) throws SQLException {
        return new Dock().getDockByName(name);
    }

    /**
     * this method get bike info by Barcode.
     *
     * @param barcode - barcode of the bike
     *
     * @return Bike information
     */
    public Bike viewBike (final String barcode) throws SQLException {
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
}
