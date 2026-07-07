public class Meter {

    double openingReading;
    double closingReading;

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
}