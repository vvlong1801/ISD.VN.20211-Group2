package ecobikerental.capstone_project.controller;

import ecobikerental.capstone_project.entity.bike.Bike;

public class RentBikeController {
    private Bike bikeRent;

    public Bike getBikeInfo(String barcode) {
        return null;
    }

    public boolean validateBarcode(String barcode) {
        if (barcode == null || barcode.length() != 13) {
            return false;
        }
        return barcode.matches("^[0-9]+");
    }

    private void changeBarcodeToBikeCode() {
    }

    public void confirmRentBike() {
    }

    public Bike getBikeRent() {
        return bikeRent;
    }

    public void setBikeRent(Bike bikeRent) {
        this.bikeRent = bikeRent;
    }
}
