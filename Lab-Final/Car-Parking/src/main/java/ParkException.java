public class ParkException extends ParkingException {
    public ParkException(String message) {
        super("No vehicle found");
    }
}
