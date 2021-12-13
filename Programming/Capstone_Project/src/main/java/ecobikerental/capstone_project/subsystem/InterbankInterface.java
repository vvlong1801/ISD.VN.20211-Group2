package ecobikerental.capstone_project.subsystem;

import ecobikerental.capstone_project.entity.payment.CreditCard;
import ecobikerental.capstone_project.entity.payment.PaymentTransaction;
import ecobikerental.capstone_project.exception.PaymentException;
import ecobikerental.capstone_project.exception.UnrecognizedException;

public interface InterbankInterface {

    /**
     * Pay order, and then return the payment transaction
     *
     * @param card     - the credit card used for payment
     * @param amount   - the amount to pay
     * @param contents - the transaction contents
     *
     * @return {@link ecobikerental.capstone_project.entity.payment.PaymentTransaction PaymentTransaction} - if the
     * payment is successful
     *
     * @throws PaymentException      if responded with a pre-defined error code
     * @throws UnrecognizedException if responded with an unknown error code or
     *                               something goes wrong
     */
    PaymentTransaction payDeposit(CreditCard card, int amount, String contents)
        throws PaymentException, UnrecognizedException;

    /**
     * Refund, and then return the payment transaction
     *
     * @param card     - the credit card which would be refunded to
     * @param amount   - the amount to refund
     * @param contents - the transaction contents
     *
     * @return {@link ecobikerental.capstone_project.entity.payment.PaymentTransaction PaymentTransaction} - if the
     * payment is successful
     *
     * @throws PaymentException      if responded with a pre-defined error code
     * @throws UnrecognizedException if responded with an unknown error code or
     *                               something goes wrong
     */
    PaymentTransaction refund(CreditCard card, int amount, String contents)
        throws PaymentException, UnrecognizedException;
}
