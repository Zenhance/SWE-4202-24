public enum SlotType {
    BIKE(10,5,0),
    REGULAR(30,20,15),
    LARGE(50,40,25);

    public final int firstHour;
    public final int furtherHour;
    public final int surcharge;

    SlotType(int firstHour, int furtherHour, int surcharge) {
        this.firstHour = firstHour;
        this.furtherHour = furtherHour;
        this.surcharge = surcharge;
    }

    public int getFirstHour() {
        return firstHour;
    }
    public int getFurtherHour() {
        return furtherHour;
    }
    public int getSurcharge() {
        return surcharge;
    }
}
