package exceptions;

public abstract class ParkingRefusedException extends RuntimeException {
    public ParkingRefusedException(String message) {
        super(message);
    }
}
