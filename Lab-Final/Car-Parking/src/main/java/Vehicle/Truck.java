package Vehicle;

import Slot.DiscountScheme;
import Slot.SlotType;

public class Truck extends  Vehicle{
    public Truck(String numberPlate, DiscountScheme discountScheme){
        super(numberPlate,discountScheme);
    }

    @Override
    public SlotType[] getAcceptedSlotTypes(){
        return new SlotType[]{
                SlotType.LARGE
        };
    }
}


