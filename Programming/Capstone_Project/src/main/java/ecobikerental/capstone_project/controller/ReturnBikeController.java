package ecobikerental.capstone_project.controller;

import ecobikerental.capstone_project.entity.bike.Bike;
import ecobikerental.capstone_project.entity.invoice.Invoice;

/**
 * This class controls the return bike process
 */
public class ReturnBikeController {
    /**
     * Represent for invoice
     */
    private Invoice invoice;

    /**
     * The method validates the dock name
     * The dock name must be letters(a-z,A-Z) and space
     * @param dockName - the name of dock
     * @return true if the dock name is correct format, false if not
     */
    public boolean validateDockName(String dockName){
        if(dockName == null) return false;
        String exp = "^[a-zA-Z][a-zA-Z\\s]{0,}$";
        return dockName.matches(exp);
    }

    /**
     * The method calculates the rental fee
     * @param bikeType - the type of bike
     * @param timeRental - the time that user rented
     * @return rentalFee - the fee corresponds to the rental time
     */
    private int calculateRentalFee(String bikeType,int timeRental){
        return 0;
    }

    /**
     * This method takes responsibility for processing the return bike
     */
    public void returnBike(){
        //validate dockname
        //
    }

    /**
     * This method gets the invoice
     * @return invoice
     */
    public Invoice getInvoice() {
        return invoice;
    }

    /**
     * This method sets the invoice
     * @param invoice - the invoice to set
     */
    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
}
