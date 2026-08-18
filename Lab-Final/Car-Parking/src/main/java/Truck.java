import java.util.List;

public class Truck extends Vehicle {
    public Truck(String plate) {
        super(plate);
    }

    @Override
    public List<SlotType> getAcceptedSlotTypes() {
        return List.of(SlotType.LARGE);
    }
}
