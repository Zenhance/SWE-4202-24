public class Meter {
    private final int openingReading;
    private final int closingReading;
    private int unitsConsumed;

    public Meter(int openingReading, int closingReading) {
        if (openingReading < 0 || closingReading < 0) {
            throw new IllegalArgumentException();
        }
        if(closingReading < openingReading){
            throw new IllegalArgumentException();
        }
        this.openingReading = openingReading;
        this.closingReading = closingReading;

        this.unitsConsumed = openingReading - closingReading;
    }

    /*public int getOpeningReading() {
        return openingReading;
    }
    public int getClosingReading() {
        return closingReading;
    }*/
    public int getUnitsConsumed() {
        return unitsConsumed;
    }
}
