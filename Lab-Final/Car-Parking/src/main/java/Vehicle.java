package main.java;

public abstract class Vehicle {
    private String plate;
    private Scheme scheme;

    public Vehicle(String plate, Scheme scheme) {
        this.plate = plate;
        this.scheme = scheme;
    }

    public String getPlate() {
        return plate;
    }

    public Scheme getScheme() {
        return scheme;
    }
    public abstract String[] getPrefferedSlot();
    public abstract String getDefaultSlot();
}
