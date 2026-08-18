import java.util.List;

public class Car extends Vehicle{
    public Car(String numberPlate,DiscountScheme scheme){
        super(numberPlate,scheme);
    }

    @Override
    public List<SlotType> acceptanceOrder() {
        return List.of(SlotType.REGULAR,SlotType.LARGE);
    }
}
