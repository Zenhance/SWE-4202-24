public class Vehicle {
    private String plate;
    private DiscountScheme discountScheme;
    private int hoursStood;
    private Slot assignedSlot;

    public Vehicle(DiscountScheme discountScheme, Slot assignedSlot){
        this.discountScheme = discountScheme;
        this.assignedSlot = assignedSlot;
        this.hoursStood = 0;
    }

}
