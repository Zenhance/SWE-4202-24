package main.java;

public class Truck extends Vehicle{
    public Truck(String plate, Scheme scheme) {
        super(plate, scheme);
    }

    @Override
    public String[] getPrefferedSlot() {
        return new String[] {"BIKE", "REGULAR", "LARGE"};
    }

    @Override
    public String getDefaultSlot() {
        return "LARGE";
    }


}
