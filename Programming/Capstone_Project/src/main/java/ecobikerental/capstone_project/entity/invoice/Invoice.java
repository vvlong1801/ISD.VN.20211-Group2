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
    private PaymentTransaction payDepositTransaction;
    private PaymentTransaction refundTransaction;

    private Invoice instance = new Invoice();
//    /**.
//     * Constructors with 3 arguments
//     * @param bike - the bike that user rented
//     * @param dock - the dock
//     * @param transaction - the payment/refundment transaction
//     */
//    private Invoice(Bike bike, Dock dock, PaymentTransaction transaction) {
//        this.bike = bike;
//        this.dock = dock;
//        this.transaction = transaction;
//    }

    /**
     * This method saves the invoice
     */
    public void save(){

    }

    public Invoice getInstance() {
        return instance;
    }

    public Bike getBike() {
        return bike;
    }

    public void setBike(Bike bike) {
        this.bike = bike;
    }

    public Dock getDock() {
        return dock;
    }

    public void setDock(Dock dock) {
        this.dock = dock;
    }

    public PaymentTransaction getPayDepositTransaction() {
        return payDepositTransaction;
    }

    public void setPayDepositTransaction(PaymentTransaction payDepositTransaction) {
        this.payDepositTransaction = payDepositTransaction;
    }

    public PaymentTransaction getRefundTransaction() {
        return refundTransaction;
    }

    public void setRefundTransaction(PaymentTransaction refundTransaction) {
        this.refundTransaction = refundTransaction;
    }
}
