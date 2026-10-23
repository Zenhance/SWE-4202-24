/** No slot this vehicle will accept is free, so it cannot be admitted. */
public class NoSlotFreeException extends Exception {

    public NoSlotFreeException(String message) {
        super(message);
    }
}
