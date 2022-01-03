package ecobikerental.capstone_project.entity.invoice;

import ecobikerental.capstone_project.entity.bike.Bike;
import ecobikerental.capstone_project.entity.payment.PaymentTransaction;

/**
 * Entity Invoice
 */
public class Invoice {
    /**
     * Represent for bike
     */
    private Bike bike;
    private String rentalTime;
    private int rentalFee;
    /**
     * Represent for payment transaction.
     */
    private PaymentTransaction payDepositTransaction;
    private PaymentTransaction refundTransaction;

    private static Invoice instance = new Invoice();

    private Invoice() {
    }


    /**
     * This method saves the invoice.
     */
    public void save() {

    }


    public static Invoice getInstance() {
        return instance;
    }

    public static void setInstance(Invoice instance) {
        Invoice.instance = instance;
    }

    public Bike getBike() {
        return bike;
    }

    public void setBike(Bike bike) {
        this.bike = bike;
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

    public void setRentalTime(String rentalTime) {
        this.rentalTime = rentalTime;
    }

    public String getRentalTime() {
        return rentalTime;
    }

    public int getRentalFee() {
        return rentalFee;
    }

    public void setRentalFee(int rentalFee) {
        this.rentalFee = rentalFee;
    }
}
