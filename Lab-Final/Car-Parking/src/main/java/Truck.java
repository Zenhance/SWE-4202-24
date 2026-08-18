import java.util.List;

public abstract class Truck extends Vehicle {
    public Truck(String plate, DiscountScheme scheme) {
        super(plate, scheme);
    }

    public List<SlotType> acceptanceOrder(){
        return List.of(SlotType.LARGE);
    }
}
