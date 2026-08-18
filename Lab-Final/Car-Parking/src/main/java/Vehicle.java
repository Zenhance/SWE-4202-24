package src.main.java;

abstract class Vehicle {
    String Plate;
    Slot slot;
    int hours;
    Discount discount;

    public Vehicle(String plate, Discount discount){
        this.Plate = plate;
        this.discount = discount;
        slot=null;
        hours = 0;
    }

}
