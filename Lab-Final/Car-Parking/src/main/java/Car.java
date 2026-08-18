import java.util.List;

public class Car extends Vehicle {
    protected Car(String plate) {
        super(plate);
    }

    @Override
    public List<SlotType> getAcceptedSlotTypes() {
        return List.of(
                SlotType.REGULAR,
                SlotType.LARGE
        );
    }
}
