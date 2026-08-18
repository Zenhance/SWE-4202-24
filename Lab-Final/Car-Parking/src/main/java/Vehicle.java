public abstract class Vehicle {
    private final String Plate;
    private final String Scheme;
    private int hours;
    private ParkingSlot slot;


    public Vehicle(String Plate, String Scheme) {
        this.Plate = Plate;
        this.Scheme = Scheme;
        this.hours = 0;
    }

    public String getPlate() {
        return Plate;
    }


    public String getScheme() {
        return Scheme;
    }