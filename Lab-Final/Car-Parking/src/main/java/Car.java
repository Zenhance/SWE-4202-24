public class Car extends Vehicle {

    public Car(String plate, Discount scheme) throws InvalidVehicleException {
        super(plate, scheme);
    }

    @Override
    public String[] slotPreference() {
        return new String[] { "REGULAR", "LARGE" };
    }
}
