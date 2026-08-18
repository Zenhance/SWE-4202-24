class Vehicle {
    private final String plate;
    private final VehicleType type;
    private final SchemeType scheme;
    private int hoursStood;

    public Vehicle(String plate, VehicleType type, SchemeType scheme) {
        this.plate = plate;
        this.type = type;
        this.scheme = scheme;
        this.hoursStood = 0;
    }

    public String getPlate() {
        return plate;
    }

    public VehicleType getType() {
        return type;
    }

    public SchemeType getScheme() {
        return scheme;
    }

    public int getHoursStood() {
        return hoursStood;
    }

    public void incrementHours(int hours) {
        this.hoursStood += hours;
    }
}