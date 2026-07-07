public class Meter {
    private final int openingReading;
    private final int closingReading;
    public Meter(int openingReading,int closingReading){
        if (openingReading < 0 || closingReading < 0) {
            throw new IllegalArgumentException("A meter's reading shouldn't be negative.");
        }
        if (closingReading < openingReading) {
            throw new IllegalArgumentException(
                    "Opening Reading should be bigger than closing reading.");
        }
        this.openingReading=openingReading;
        this.closingReading=closingReading;
    }

}
