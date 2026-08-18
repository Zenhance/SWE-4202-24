public enum SlotKind {
    BIKE(10, 5, 0),
    REGULAR(30, 20, 15),
    LARGE(50, 40, 25);

    private final int firstHourFee;
    private final int furtherHourFee;
    private final int surcharge;

    SlotKind(int firstHourFee, int furtherHourFee, int surcharge) {
        this.firstHourFee = firstHourFee;
        this.furtherHourFee = furtherHourFee;
        this.surcharge = surcharge;
    }

    public int firstHourFee() {
        return firstHourFee;
    }

    public int furtherHourFee() {
        return furtherHourFee;
    }

    public int surcharge() {
        return surcharge;
    }
}
