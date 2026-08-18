public class EmptyPlateException extends ParkingException {

    public EmptyPlateException() {
        super("Vehicle has no plate");
    }
}