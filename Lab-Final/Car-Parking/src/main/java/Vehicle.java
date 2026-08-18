public class Vehicle {
    private String plate;
    private DiscountScheme discountScheme;
    private int hoursStood;
    private Slot assignedSlot;

    public Vehicle( String plate, Slot assignedSlot){
        this.plate = plate;
        this.assignedSlot = assignedSlot;
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
}
