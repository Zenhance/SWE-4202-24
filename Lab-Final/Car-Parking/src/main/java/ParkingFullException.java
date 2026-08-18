public class ParkingFullException extends Exception{
    public ParkingFullException(String vehiclePlate){
        super("No slot available for vehicled "+vehiclePlate);
    }
}
