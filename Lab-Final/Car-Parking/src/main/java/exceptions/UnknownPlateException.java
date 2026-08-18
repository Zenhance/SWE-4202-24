package exceptions;

public class UnknownPlateException extends ParkingException {
    public UnknownPlateException(String message) {
        super(message);
    }
}
