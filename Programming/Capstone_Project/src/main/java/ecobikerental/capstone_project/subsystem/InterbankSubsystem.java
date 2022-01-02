package ecobikerental.capstone_project.subsystem;

import ecobikerental.capstone_project.entity.payment.CreditCard;
import ecobikerental.capstone_project.entity.payment.PaymentTransaction;
import ecobikerental.capstone_project.subsystem.interbank.InterbankSubsystemController;

public class InterbankSubsystem implements InterbankInterface {

    /**
     * Represent the controller of the subsystem
     */
    private InterbankSubsystemController ctrl;

    /**
     * Initializes a newly created {@code InterbankSubsystem} object so that it
     * represents an Interbank subsystem.
     */
    public InterbankSubsystem() {
        String str = new String();
        this.ctrl = new InterbankSubsystemController();
    }

    /**
     * @see InterbankInterface#payDeposit(ecobikerental.capstone_project.entity.payment.CreditCard, int,
     * java.lang.String)
     */
    public PaymentTransaction payDeposit(CreditCard card, int amount, String contents) {
        PaymentTransaction transaction = ctrl.payDeposit(card, amount, contents);
        return transaction;
    }

    /**
     * this method process refund.
     *
     * @param card
     * @param amount
     * @param contents
     *
     * @return PaymentTransaction
     *
     * @see InterbankInterface#refund(ecobikerental.capstone_project.entity.payment.CreditCard, int,
     * java.lang.String)
     */
    public PaymentTransaction refund(CreditCard card, int amount, String contents) {
        PaymentTransaction transaction = ctrl.refund(card, amount, contents);
        return transaction;
    }
}
