package ecobikerental.capstone_project.exception;

public class InvalidVersionException extends PaymentException{
    public InvalidVersionException() {
        super("ERROR: Invalid Version Information!");
    }
}
