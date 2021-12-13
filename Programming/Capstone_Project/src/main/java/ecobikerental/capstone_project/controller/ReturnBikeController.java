package ecobikerental.capstone_project.controller;

import ecobikerental.capstone_project.entity.bike.Bike;
import ecobikerental.capstone_project.entity.invoice.Invoice;

public class ReturnBikeController {
    private Invoice invoice;

    public boolean validateDockName(String dockName){
        if(dockName == null) return false;
        String exp = "^[a-zA-Z][a-zA-Z\\s]{0,}$";
        return dockName.matches(exp);
    }

    private int calculateRentalFee(String bikeType,int timeRental){
        return 0;
    }

    public void returnBike(){
        //validate dockname
        //
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
}
