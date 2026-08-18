public class VehicleNotFoundException extends ParkingException {

    public VehicleNotFoundException(String plate) {
        super("Vehicle not found: " + plate);
    }
}