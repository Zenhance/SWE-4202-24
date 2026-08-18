public enum SlotType {
    BIKE(10,5, 0),
    REGULAR(30, 20, 15),
    LARGE(50, 40, 25);

    private final int firstHourFee;
    private final int furtherHourFee;
    private final int surcharge;

    SlotType(int firstHourFee, int furtherHourFee, int surcharge) {
        this.firstHourFee = firstHourFee;
        this.furtherHourFee = furtherHourFee;
        this.surcharge = surcharge;
    }
}
