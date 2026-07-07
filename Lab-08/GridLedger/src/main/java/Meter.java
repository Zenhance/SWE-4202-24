public class Meter {
    private final int openingReading;
    private final int closingReading;

    public Meter(int openingReading, int closingReading) {
        this.openingReading = openingReading;
        this.closingReading = closingReading;
    }

    public int getUnitsConsumed() {
        return closingReading - openingReading;
    }
}
