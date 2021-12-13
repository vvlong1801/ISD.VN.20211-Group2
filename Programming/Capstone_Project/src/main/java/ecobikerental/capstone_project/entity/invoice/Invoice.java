package ecobikerental.capstone_project.entity.invoice;

import ecobikerental.capstone_project.entity.bike.Bike;
import ecobikerental.capstone_project.entity.dock.Dock;
import ecobikerental.capstone_project.entity.payment.PaymentTransaction;

public class Invoice {
    private Bike bike;
    private Dock dock;
    private PaymentTransaction transaction;

    public Invoice(Bike bike, Dock dock, PaymentTransaction transaction) {
        this.bike = bike;
        this.dock = dock;
        this.transaction = transaction;
    }

    public void save(){

    }
}
