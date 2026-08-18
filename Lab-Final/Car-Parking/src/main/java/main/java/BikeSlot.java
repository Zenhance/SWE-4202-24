package main.java;

public class BikeSlot extends Slot{
    public BikeSlot() {
        super(10, 5, 0);
    }

    @Override
    public String getSlot() {
        return "Bike";
    }
}
