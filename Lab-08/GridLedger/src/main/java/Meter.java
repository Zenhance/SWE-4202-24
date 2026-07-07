public class Meter {
    private int openingReading;
    private int closingReading;

    public Meter(int openingReading, int closingReading) {
        if (openingReading < 0) {
            throw new IllegalArgumentException("Invalid input");
        } else {
            this.openingReading = openingReading;
        }
        if (closingReading < openingReading) {
            throw new IllegalArgumentException("Invalid input");
        } else {
            this.closingReading = closingReading;
        }

        public int getUnitsConsumed () {
            return closingReading - openingReading;
        }
    }
}
