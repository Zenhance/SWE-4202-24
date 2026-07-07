package java;

public class Meter {
    private final int openingReadings;
    private final int closingReadings;

    public Meter (int openingReadings, int closingReadings) {
        if (openingReadings < 0 || closingReadings < 0) {
            throw new IllegalArgumentException("Negative Readings is impossible");
        }
        this.openingReadings = openingReadings;
    }
}
