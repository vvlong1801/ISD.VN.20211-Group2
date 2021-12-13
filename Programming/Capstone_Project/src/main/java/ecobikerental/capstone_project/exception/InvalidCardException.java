package ecobikerental.capstone_project.exception;

public class InvalidCardException extends PaymentException {
    public InvalidCardException() {
        super("ERROR: Invalid card!");
    }
}
