import java.util.List;

public class Truck extends Vehicle {
    @Override
    public List<SlotType> getAcceptedSlotTypes() {
        return List.of(SlotType.LARGE);
    }
}
