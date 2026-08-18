public class ParkingFullException extends Exception{
    public ParkingFullException(String plate){
        super("No slot available");
    }
}
