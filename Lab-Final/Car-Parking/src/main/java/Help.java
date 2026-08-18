public class Help {
    private final String plate;
    private final DiscountScheme discountScheme;
    private int hoursStood;
    private Slot assignedSlot;

    public Vehicle(String plate, DiscountScheme discountScheme) {
        this.plate = plate;
        this.discountScheme = discountScheme;
        this.hoursStood = 0;
    }
}
