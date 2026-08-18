package Vehicle;

import Slot.DiscountScheme;
import Slot.SlotType;

public class Motorcycle extends Vehicle {
    public Motorcycle(String numberPlate, DiscountScheme discountScheme){
        super(numberPlate, discountScheme);
    }

    @Override
    public SlotType [] getAcceptedSlotTypes(){
        return new SlotType[]{
                SlotType.BIKE,
                SlotType.REGULAR,
                SlotType.LARGE
        };
    }
}
