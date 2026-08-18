package model;

public class Bike extends Vehicle {
    public Bike(String licencePlate, String permit) {
        super(licencePlate, permit);
    }

    @Override
    public String[] slotOrder() {
        return new String[]{"BIKE", "REGULAR", "LARGE"};
    }

    @Override
    public String bestSlot() {
        return "BIKE";
    }

}
