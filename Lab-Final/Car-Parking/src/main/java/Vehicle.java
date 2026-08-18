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

}
