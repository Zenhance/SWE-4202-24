import java.util.List;

public class Vehicle {
    private String plate;
    private DiscountScheme discountScheme;
    private int hoursStood;
    private Slot assignedSlot;

    public Vehicle( String plate, DiscountScheme discountScheme){
        this.plate = plate;
        this.discountScheme = discountScheme;

        this.hoursStood = 0;
    }

    public String getPlate() {
        return plate;
    }

    public DiscountScheme getDiscountScheme() {
        return discountScheme;
    }

    public int getHoursStood() {
        return hoursStood;
    }

    public Slot getAssignedSlot() {
        return assignedSlot;
    }

    public void setAssignedSlot(Slot assignedSlot) {
        this.assignedSlot = assignedSlot;
    }

    public void setDiscountScheme(DiscountScheme discountScheme) {
        this.discountScheme = discountScheme;
    }

    public void addHours(int hours) {
        this.hoursStood += hours;
    }

    public SlotKind getHomeSlotKind() {
        return null;
    }

    public List<SlotKind> getPreferredSlots() {
        return null;
    }

    public  int calculateCurrentBill() {
        int rawBill = assignedSlot.calculateRawBill(this, hoursStood);
        return discountScheme.applyDiscount(rawBill);
    }


}
