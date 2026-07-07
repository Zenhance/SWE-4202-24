public class Meter {
    private double openingReading;
    private double closingReading;

    public Meter(double openingReading, double closingReading) {
        if(openingReading < 0 || closingReading < 0){
            throw new IllegalArgumentException("Opening and Closing readings cannot be negative");
        }

        if(closingReading < openingReading) {
            throw new IllegalArgumentException("Closing readings cannot be less than opening reading");
        }
        this.openingReading = openingReading;
        this.closingReading = closingReading;
    }

    public double getOpeningReading() {
        return openingReading;
    }

    public double getClosingReading() {
        return closingReading;
    }

    public double unitConsumed() {
        return closingReading - openingReading;
    }
}
