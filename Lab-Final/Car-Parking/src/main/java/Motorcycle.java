import java.util.List;

public class Motorcycle extends Vehicle {
    protected Motorcycle(String plate) {
        super(plate);
    }

    @Override
    public List<SlotType> getAcceptedSlotTypes() {
        return List.of(
                SlotType.BIKE,
                SlotType.REGULAR,
                SlotType.LARGE
        );
    }
}
