import java.util.Scanner;

public class Main {

    enum VehicleType {
        BIKE,
        CAR,
        TRUCK
    }

    enum SlotType {
        BIKE,
        REGULAR,
        LARGE
    }

    enum DiscountType {
        NONE,
        STUDENT,
        WEEKEND
    }


    public static class Vehicle {
        String numPlate;
        VehicleType type;
        SlotType slotType;
        DiscountType discountType;

        int entryHour;

        Vehicle(String numPlate, VehicleType type, SlotType slotType, DiscountType discountType, int entryHour) {
            this.numPlate = numPlate;
            this.type = type;
            this.slotType = slotType;
            this.discountType = discountType;
            this.entryHour = entryHour;
        }
    }

    public static void main(String[] args){
    }
}