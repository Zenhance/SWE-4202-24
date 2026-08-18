package main.java;

public class Car extends Vehicle{
    public Car(String plate, Scheme scheme) {
        super(plate, scheme);
    }

    @Override
    public String[] getPrefferedSlot() {
        return new String[] {"REGULAR", "LARGE"};
    }

    @Override
    public String getDefaultSlot() {
        return "REGULAR";
    }



}
