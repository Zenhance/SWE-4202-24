public class Truck extends Vehicle {

    public Truck(String plate, Discount scheme) throws InvalidVehicleException {
        super(plate, scheme);
    }

    @Override
    public String[] slotPreference() {
        return new String[] { "LARGE" };
    }
}
