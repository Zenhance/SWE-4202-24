public class discountScheme {
    private slotType slot;

    public discountScheme(slotType slot) {
        if (slot == null)
            throw new IllegalArgumentException("Slot cannot be null");
        this.slot = slot;
    }
}