package ecobikerental.capstone_project.subsystem.interbank;

import ecobikerental.capstone_project.entity.payment.CreditCard;
import ecobikerental.capstone_project.entity.payment.PaymentTransaction;

public class Response {
    private String errorCode;
    private Transaction transaction;

    public PaymentTransaction toPaymentTransaction() {
        CreditCard creditCard =
            new CreditCard(this.transaction.getCardCode(), this.transaction.getOwner(), this.transaction.getCvvCode(),
                this.transaction.getDateExpired());
        return new PaymentTransaction(this.errorCode, creditCard, this.transaction.getTransactionId(),
            this.transaction.getTransactionContent(), this.transaction.getCommand(), this.transaction.getAmount(), this.transaction.getCreatedAt());
    }
}
