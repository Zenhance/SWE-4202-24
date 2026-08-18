package model;

public class Car extends Vehicle{
    public Car(String licencePlate, String permit) {
        super(licencePlate, permit);
    }

    @Override
    public String[] slotOrder() {
        return new String[] {"REGULAR", "LARGE"};
    }
}
