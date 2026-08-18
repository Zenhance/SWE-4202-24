import java.util.List;

public class Motorcycle extends Vehicle {
    public Motorcycle(String plate, DiscountScheme discount) {
        super(plate, discount);
    }

    @Override
    public SlotKind getHomeSlotKind() {
        return SlotKind.BIKE;
    }

    @Override
    public List<SlotKind> getPreferredSlots() {
        return List.of(SlotKind.LARGE, SlotKind.REGULAR, SlotKind.BIKE);
    }
}