/** A vehicle that may not exist at all: no plate, or no discount scheme. */
public class InvalidVehicleException extends Exception {

    public InvalidVehicleException(String message) {
        super(message);
    }
}
