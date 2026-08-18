import java.util.List;

public class Motorcycle extends Vehicle {

    @Override
    public List<SlotType> getAcceptedSlotTypes() {
        return List.of(
                SlotType.BIKE,
                SlotType.REGULAR,
                SlotType.LARGE
        );
    }
}
