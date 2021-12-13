package ecobikerental.capstone_project.entity.invoice;

import ecobikerental.capstone_project.entity.bike.Bike;
import ecobikerental.capstone_project.entity.dock.Dock;
import ecobikerental.capstone_project.entity.payment.PaymentTransaction;

/**
 * Entity Invoice
 */
public class Invoice {
    /**
     * Represent for bike
     */
    private Bike bike;
    /**
     * Represent for dock
     */
    private Dock dock;
    /**
     * Represent for payment transaction
     */
    private PaymentTransaction transaction;

    /**
     * Constructors with 3 arguments
     * @param bike - the bike that user rented
     * @param dock - the dock
     * @param transaction - the payment/refundment transaction
     */
    public Invoice(Bike bike, Dock dock, PaymentTransaction transaction) {
        this.bike = bike;
        this.dock = dock;
        this.transaction = transaction;
    }

    /**
     * This method saves the invoice
     */
    public void save(){

    }
}
