public class NoSlotException extends ParkingException {

    public NoSlotException() {
        super("No suitable slot is available");
    }
}