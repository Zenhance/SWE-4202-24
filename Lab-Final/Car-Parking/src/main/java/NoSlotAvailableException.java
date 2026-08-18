public class NoSlotAvailableException extends Exception {
    public NoSlotAvailableException() {
        super("No slot available for this vehicle");
    }

    public NoSlotAvailableException(String message) {
        super(message);
    }
}
