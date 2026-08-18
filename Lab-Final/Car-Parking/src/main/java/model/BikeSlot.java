package model;

public class BikeSlot extends Slot{
    public BikeSlot(int total){
        super(total);
        this.firstHourCharge =  10;
        extraHourCharge = 5;
        surcharge = 0;
    }

    @Override
    public boolean allowedType(String type) {
        return type.equals("BIKE");
    }
}
