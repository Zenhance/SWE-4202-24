import java.util.List;

public class Car extends Vehicle {
    public Car(String plate, DiscountScheme discount) {
        super(plate, discount);
    }

    @Override
    public SlotKind getHomeSlotKind() {
        return SlotKind.REGULAR;
    }

    @Override
    public List<SlotKind> getPreferredSlots() {
        // Car prefers REGULAR, then LARGE
        return List.of(SlotKind.REGULAR, SlotKind.LARGE);
    }
}