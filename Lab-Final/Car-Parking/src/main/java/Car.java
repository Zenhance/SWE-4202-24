package main.java;

public class Car extends Vehicle{
    public Car(String plate, Scheme scheme) {
        super(plate, scheme);
    }

    @Override
    public String getPrefferedSlot() {
        return "REGULAR";
    }
}
