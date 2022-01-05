package ecobikerental.capstone_project.business_layer.rentalfee;

public interface RentalFee {
    /**
     * @param rentalTime -
     *
     * @return - rental fee
     */
    int calculate(String rentalTime);
}
