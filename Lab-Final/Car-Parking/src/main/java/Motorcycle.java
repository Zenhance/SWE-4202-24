import java.util.List;

public abstract class Motorcycle extends Vehicle{
    public Motorcycle(String plate,DiscountScheme scheme){
        super(plate, scheme);
    }

    @Override
    public List<SlotType> acceptanceOrder(){
        return List.of(SlotType.BIKE,SlotType.REGULAR,SlotType.LARGE);
    }

}
