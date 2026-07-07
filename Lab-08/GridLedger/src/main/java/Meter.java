public class Meter {
    private int openingReading;
    private int closingReading;

    public Meter(int openingReading, int closingReading) {
        if (openingReading < 0 || closingReading < 0) {
            throw new IllegalArgumentException("No negative values allowed");
        }

        if (openingReading > closingReading) {
            throw new IllegalArgumentException("Closing reading has to be above the opening value");
        }

        this.openingReading = openingReading;
        this.closingReading = closingReading;
    }

    public int getUnitsConsumed() {
    }

    public int getOpeningReading() {
        return openingReading;
    }

    public int getClosingReading() {
        return closingReading;
    }
}
