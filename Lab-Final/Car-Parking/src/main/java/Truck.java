import java.util.List;

public class Truck extends Vehicle {
    public Truck(String plate, DiscountScheme discountScheme) {
        super(plate, discountScheme);
    }

    @Override
    public List<SlotKind> acceptableSlotKinds() {
        return null;
    }
}
