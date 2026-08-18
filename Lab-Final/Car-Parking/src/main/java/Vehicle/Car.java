package Vehicle;

import Slot.DiscountScheme;
import Slot.SlotType;

public class Car extends Vehicle{
    public Car(String numberPlate, DiscountScheme discountScheme){
        super(numberPlate, discountScheme);
    }
    @Override
    public SlotType[] getAcceptedSlotTypes(){
        return new SlotType[]{
                SlotType.LARGE,
                SlotType.REGULAR
        };
    }
}
