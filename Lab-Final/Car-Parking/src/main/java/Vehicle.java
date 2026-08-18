public abstract class Vehicle {
    private final String plate;
    private final String scheme;

    private int hours;
    private ParkingSlot slot;

    public Vehicle(String plate, String scheme) {
        this.plate = plate;
        this.scheme = scheme;
        this.hours = 0;
    }

    public String getPlate() {
        return plate;
    }
    public String getScheme() {
        return scheme;
    }

}
