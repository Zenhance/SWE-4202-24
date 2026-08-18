import java.util.List;

public class Motorcycle extends Vehicle{
    public Motorcycle(String numberPlate,DiscountScheme scheme){
        super(numberPlate,scheme);
    }

    @Override
    public List<SlotType> acceptanceOrder() {
        return List.of(SlotType.BIKE,SlotType.REGULAR,SlotType.LARGE);
    }
}
