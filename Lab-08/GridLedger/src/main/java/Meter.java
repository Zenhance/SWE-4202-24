public class Meter {
    private double closingReading;
    private double openingReading;

    public Meter (double closingReading, double openingReading) {
        if ((openingReading <0 && closingReading <0) && (closingReading < openingReading)) {
            throw new IllegalArgumentException("Invalid value of Reading");
        }

        else {
            this.closingReading = closingReading;
            this.openingReading = openingReading;
        }
    }

    public double getClosingReading() {
        return closingReading;
    }

    public double getOpeningReading() {
        return openingReading;
    }

    public double getUnitsConsumed() {
        return closingReading - openingReading;
    }
}
