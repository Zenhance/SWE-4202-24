import java.util.List;

public abstract class MotorCycle extends Vehicle {

    protected MotorCycle(String numberPlate, DiscountScheme discountScheme) {
        super(numberPlate, discountScheme);
    }
    @Override

    public List<SlotType> acceptanceOrder(){
        return List.of(SlotType.BIKE,SlotType.REGULAR,SlotType.LARGE);
    }
}
