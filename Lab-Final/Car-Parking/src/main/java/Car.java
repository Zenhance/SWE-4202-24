import java.util.List;

public abstract class Car extends Vehicle {

    protected Car(String numberPlate, DiscountScheme discountScheme) {
        super(numberPlate, discountScheme);
    }
    @Override
    public SlotType homeSlot(){
    return SlotType.REGULAR;
    }

    @Override
    public List<SlotType> acceptanceOrder() {
        return List.of(SlotType.REGULAR,SlotType.LARGE);
    }
}
