public class Meter {
    private final int openingReading;
    private final int closingReading;

    public Meter(int openingReading, int closingReading) {
        if (openingReading < 0 || closingReading < 0) {
            throw new IllegalArgumentException("Reading cannot be negative");
        }

        if (closingReading < openingReading) {
            throw new IllegalArgumentException("Closing reading cannot be less than opening reading");
        }
        this.openingReading = openingReading;
        this.closingReading = closingReading;
    }

    public int getUnitsConsumed() {
        return closingReading - openingReading;
    }
}
