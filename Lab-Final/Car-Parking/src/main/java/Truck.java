import java.util.List;

public final class Truck extends Vehicle {
    public Truck(String plate,DiscountScheme discount
    ) {super(plate, discount);
    }

    @Override
    public List<SlotKind> acceptedSlots() {
        return List.of(SlotKind.LARGE);
    }
}