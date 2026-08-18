import java.util.List;
public abstract class MotorCycle extends Vehicle{
    public MotorCycle(String plate, DiscountScheme scheme){
        super(plate, scheme);
    }
    public List<SlotType>acceptanceOrder(){
        return List.of(SlotType.BIKE, SlotType.REGULAR, StotType.LARGE);
    }
}
