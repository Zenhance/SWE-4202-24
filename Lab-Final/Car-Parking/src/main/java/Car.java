import java.util.List;

public final class Car extends Vehicle {
    public Car(String plate, DiscountScheme discount) {
        super(plate, discount);
    }

    @Override
    public List<SlotKind> acceptedSlots() {
        return List.of(
                SlotKind.REGULAR,
                SlotKind.LARGE
        );
    }
}