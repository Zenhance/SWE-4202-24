public class Motorcycle extends Vehicle {

    public Motorcycle(String plate, Discount scheme) throws InvalidVehicleException {
        super(plate, scheme);
    }

    @Override
    public String[] slotPreference() {
        return new String[] { "BIKE", "REGULAR", "LARGE" };
    }
}
