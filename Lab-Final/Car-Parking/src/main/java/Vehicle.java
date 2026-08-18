import java.util.List;

public abstract class Vehicle {
    private final String plate;
    private int hoursStood;
    private final DiscountScheme discountScheme;

    public Vehicle(String plate, DiscountScheme discountScheme) {
        this.plate = plate;
        this.discountScheme = discountScheme;
    }

    public abstract List<SlotKind> acceptableSlotKinds();

    public SlotKind belongsIn() {
        return null;
    }

    public String getPlate() {
        return plate;
    }

    public int getHoursStood() {
        return hoursStood;
    }

    public void addHours(int hours) {
    }

    public int calculateBill(Slot slot) {
        return 0;
    }

    public DiscountScheme getDiscountScheme() {
        return discountScheme;
    }
}
