package main.java;

public class Truck extends Vehicle{
    public Truck(String plate, Scheme scheme) {
        super(plate, scheme);
    }

    @Override
    public String getPrefferedSlot() {
        return "TRUCK";
    }
}
