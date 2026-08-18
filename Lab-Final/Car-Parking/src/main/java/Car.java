import java.util.List;

public class Car extends Vehicle {
    public Car(String plate, DiscountScheme discountScheme) {
        super(plate, discountScheme);
    }

    @Override
    public List<SlotKind> acceptableSlotKinds() {
        return List.of(SlotKind.REGULAR, SlotKind.LARGE);
    }
}
