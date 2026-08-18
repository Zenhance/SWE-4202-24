package model;

public class LargeSlot extends Slot{
    public LargeSlot(int total){
        super(total);
        this.firstHourCharge =  50;
        extraHourCharge = 40;
        surcharge = 25;
    }

    @Override
    public boolean allowedType(String type) {
        return type.equals("BIKE") || type.equals("CAR") || type.equals("TRUCK");
    }
}