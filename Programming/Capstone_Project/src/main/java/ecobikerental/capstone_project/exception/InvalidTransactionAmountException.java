package ecobikerental.capstone_project.exception;

public class InvalidTransactionAmountException extends PaymentException {
    public InvalidTransactionAmountException() {
        super("ERROR: Invalid Transaction Amount!");
    }
}

