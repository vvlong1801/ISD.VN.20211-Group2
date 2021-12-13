package ecobikerental.capstone_project.exception;

public class SuspiciousTransactionException extends PaymentException {
    public SuspiciousTransactionException() {
        super("ERROR: Suspicious Transaction Report!");
    }
}
