import java.util.List;

public abstract class Vehicle {
    private final String plate;
    private final DiscountScheme discount;
    private int hours;

    protected Vehicle(
            String plate,
            DiscountScheme discount
    ) {
        this.plate = plate;
        this.discount = discount;
    }

    public String plate() {
        return plate;
    }

    public DiscountScheme discount() {
        return discount;
    }

    public int hours() {
        return hours;
    }

    public void addHours(int hours) {
        this.hours += hours;
    }

    public SlotKind ownSlotKind() {
        return acceptedSlots().get(0);
    }

    public abstract List<SlotKind> acceptedSlots();
}
