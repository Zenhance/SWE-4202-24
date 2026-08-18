import java.util.List;

public class Truck extends Vehicle{
    public Truck(String numberPlate,DiscountScheme scheme){
        super(numberPlate,scheme);
    }

    @Override
    public List<SlotType> acceptanceOrder() {
        return List.of(SlotType.LARGE);
    }
}
