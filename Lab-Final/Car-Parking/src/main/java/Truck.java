import java.util.List;
public abstract class Truck extends Vehicle{
    public Truck(String plate, DiscountScheme scheme){
        super(plate, scheme);
    }
    @Override
    public List<SlotType>acceptanceOrder(){
        return List.of(SlotType.LARGE);
    }}