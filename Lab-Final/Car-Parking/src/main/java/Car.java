import java.util.List;

public class Car extends Vehicle {
    @Override
    public List<SlotType> getAcceptedSlotTypes() {
        return List.of(
                SlotType.REGULAR,
                SlotType.LARGE
        );
    }
}
