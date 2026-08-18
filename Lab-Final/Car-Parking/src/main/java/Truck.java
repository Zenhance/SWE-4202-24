import java.util.List;

public class Truck extends Vehicle {
    public Truck(String plate, DiscountScheme discount) {
        super(plate, discount);
    }

    @Override
    public SlotKind getHomeSlotKind() {
        return SlotKind.LARGE;
    }

    @Override
    public List<SlotKind> getPreferredSlots() {
        return List.of(SlotKind.LARGE);
    }
}