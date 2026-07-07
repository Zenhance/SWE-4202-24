public class Meter {

    private double openingReading;
    private double closingReading;

    public Meter(double openingReading, double closingReading) {
        if (openingReading > closingReading) {
            System.out.println("Invalid entries");
        }
        else if (openingReading < 0 || closingReading < 0) {
            System.out.println("Invalid enties");
        }

        else
        this.openingReading = openingReading;
        this.closingReading = closingReading;
    }

    public double getOpeningReading() {
        return openingReading;
    }
    public double getClosingReading() {
        return closingReading;
    }

    public double getUnitsConsumed() {
        return closingReading-openingReading;

    }
}