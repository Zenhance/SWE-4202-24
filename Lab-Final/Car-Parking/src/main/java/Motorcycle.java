import java.util.Arrays;
import java.util.List;

public abstract class Motorcycle extends Vehicle {
    public Motorcycle(String plate, DiscountScheme scheme) {
        super(plate, scheme);
    }

    public List<SlotType> acceptanceOrder(){
        return List.of(SlotType.BIKE,SlotType.REGULAR,SlotType.LARGE);
    }
}
