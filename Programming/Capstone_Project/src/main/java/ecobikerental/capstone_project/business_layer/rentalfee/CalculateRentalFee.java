package ecobikerental.capstone_project.business_layer.rentalfee;

import ecobikerental.capstone_project.utils.Utils;

public class CalculateRentalFee implements RentalFee {
    /**
     * This method calculates the rental fee.
     *
     * @param rentalTime - the time that user rented bike
     *
     * @return rentalFee - the rental fee
     */
    @Override
    public int calculate(String rentalTime) {
        int rentalFee = 0;
        int minutes = Utils.processTime(rentalTime);
        if (minutes <= 10) {
            rentalFee = 0;
        } else if (minutes < 30) {
            rentalFee = 10000;
        } else if (minutes % 15 == 0) {
            rentalFee = 10000 + (minutes - 30) / 15 * 3000;
        } else {
            rentalFee = 10000 + ((minutes - 30) / 15 + 1) * 3000;
        }
        return rentalFee;
    }
}
