package model;

public class RegularSlot extends Slot{
    public RegularSlot(int total){
        super(total);
        this.firstHourCharge =  30;
        extraHourCharge = 20;
        surcharge = 15;
    }

    @Override
    public boolean allowedType(String type) {
        return type.equals("BIKE") || type.equals("CAR");
    }
}
