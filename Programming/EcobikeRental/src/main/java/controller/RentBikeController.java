package controller;

import entity.bike.Bike;

public class RentBikeController extends BaseController {

    public boolean validateBarcode(String barcode){
        if (barcode==null||barcode.length()!=13) return false;
        return barcode.matches("^[0-9]+");
    }

    private void changeBarcodeToBikeCode(){}

    public Bike getBikeInfo(){
        return null;
    }

    public void confirmRentBike(){}


}
