package main.java;

public class Bike extends Vehicle{
    public Bike(String plate, Scheme scheme) {
        super(plate, scheme);
    }

    @Override
    public String getPrefferedSlot() {
        return "BIKE";
    }
}
