import java.util.List;

public class Motorcycle extends Vehicle {
    public Motorcycle(String plate, DiscountScheme discountScheme) {
        super(plate, discountScheme);
    }

    @Override
    public List<SlotKind> acceptableSlotKinds() {
        return null;
    }
}
