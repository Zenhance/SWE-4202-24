public class Meter {
    private final int unitsConsumed;

    public Meter(int openingReading, int closingReading) {
        if (openingReading < 0 || closingReading < 0) {
            throw new IllegalArgumentException();
        }
        if(closingReading < openingReading){
            throw new IllegalArgumentException();
        }

        this.unitsConsumed = openingReading - closingReading;
    }

    public int getUnitsConsumed() {
        return unitsConsumed;
    }
}
