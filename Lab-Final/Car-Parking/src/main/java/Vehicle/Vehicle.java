package Vehicle;

import Slot.DiscountScheme;
import Slot.SlotType;

public abstract class Vehicle {
    private final String numberPlate;
    private final DiscountScheme discountScheme;
    private int entryTime;

    public Vehicle(String numberPlate, DiscountScheme discountScheme){
        if(numberPlate==null ){
            throw new IllegalArgumentException("number plate should not be null");
        }
        if(discountScheme==null){
            throw new IllegalArgumentException("Invalid discount scheme");
        }
        this.numberPlate=numberPlate;
        this.discountScheme=discountScheme;
        this.entryTime=0;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public DiscountScheme getDiscountScheme() {
        return discountScheme;
    }

    public int getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(int entryTime){
        this.entryTime=entryTime;
    }

    public abstract SlotType[] getAcceptedSlotTypes();
}
