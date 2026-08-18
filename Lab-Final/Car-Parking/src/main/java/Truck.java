import java.util.List;
public abstract class Truck extends Vehicle{

    protected Truck(String numberPlate, DiscountScheme discountScheme) {
        super(numberPlate, discountScheme);
    }
    @Override
    public List<SlotType> acceptenceOrder(){
        return List.of(SlotType.LARGE);
    }
}
