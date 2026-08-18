import java.util.List;

public class Truck extends Vehicle {
    protected Truck(String plate) {
        super(plate);
    }

    @Override
    public List<SlotType> getAcceptedSlotTypes() {
        return List.of(SlotType.LARGE);
    }
}
