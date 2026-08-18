package exceptions;

public class InvalidLicensePlateException extends RuntimeException {
    public InvalidLicensePlateException(String message) {
        super(message);
    }
}
