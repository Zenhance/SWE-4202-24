package model;

public class Truck extends Vehicle {
    public Truck(String licencePlate, String permit){
        super(licencePlate, permit);
    }

    @Override
    public String[] slotOrder() {
        return new String[] {"LARGE"};
    }
}
