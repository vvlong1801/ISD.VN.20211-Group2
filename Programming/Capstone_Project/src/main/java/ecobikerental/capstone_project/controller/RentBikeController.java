package ecobikerental.capstone_project.controller;

import java.sql.SQLException;

import ecobikerental.capstone_project.business_layer.BikeBL;
import ecobikerental.capstone_project.dbconnnection_layer.BikeDL;
import ecobikerental.capstone_project.entity.bike.Bike;

/**
 * This class controls the flow of events when users want to rent bike
 */
public class RentBikeController extends BaseController {

    /**
     * This method get bike info by Barcode
     * @param barcode - barcode of the bike
     * @return Bike information
     */
    public Bike viewBike(final String dockName, final String barcode) throws SQLException {

        String bikeCode = BikeBL.convertBarcodeToBikeCode(barcode);
        if (bikeCode != null) {
            return new BikeDL().getBikeByBikeCode(bikeCode, dockName);
        } else {
            return null;
        }
    }

<<<<<<< HEAD
    /**
     * This method process confirm rent bike.
     */
    public void confirmRentBike() {

    }

//    public static void main(String[] args) {
//        Bike bike = null;
//        try {
//            bike = new RentBikeController().viewBike("Bach Khoa", "2278346617372");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        System.out.println(bike.toString());
//    }
=======
    public static void main(String[] args) {
        Bike bike = null;
        try {
            bike = new RentBikeController().viewBike("Bach Khoa", "2278346617372");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(bike.toString());
    }
>>>>>>> 55626055c6ceeed428edac9b3852e838a0e9a337
}
