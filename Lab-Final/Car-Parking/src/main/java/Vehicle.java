package src.main.java;

public abstract class Vehicle {
    String Plate;
    Slot slot;
    int hours;
    Discount discount;

    public Vehicle(String plate) {
        this.Plate = plate;
        slot = null;
        hours = 0;
    }
}

