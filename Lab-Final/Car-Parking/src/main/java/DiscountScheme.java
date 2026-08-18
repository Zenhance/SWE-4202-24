public class DiscountScheme {
    private Slot slot;

    public DiscountScheme(Slot slot) {
        if (slot == null)
            throw new IllegalArgumentException("Slot cannot be null");
        this.slot = slot;
    }
}
