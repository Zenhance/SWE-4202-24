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
        return acceptableSlotKinds().get(0);
    }

    public String getPlate() {
        return plate;
    }

    public int getHoursStood() {
        return hoursStood;
    }

    public void addHours(int hours) {
        this.hoursStood += hours;
    }

    public int calculateBill(Slot slot) {
        int h = Math.max(1, hoursStood);
        return calculateBillForHours(slot, h);
    }

    public int calculateBillForHours(Slot slot, int hours) {
        SlotKind slotKind = slot.getKind();
        int raw = slotKind.firstHourFee() + (hours - 1) * slotKind.furtherHourFee();
        if (!slotKind.equals(belongsIn())) {
            raw += slotKind.surcharge();
        }
        return discountScheme.apply(raw);
    }

    public DiscountScheme getDiscountScheme() {
        return discountScheme;
    }
}
