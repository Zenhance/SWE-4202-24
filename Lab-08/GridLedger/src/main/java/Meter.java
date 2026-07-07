public class Meter{
    public final int openingReading;
    public final int closingReading;

    public Meter(int openingReading, int closingReading){
        if (openingReading<0)
            throw new IllegalArgumentException("A meter reading cannot be negative.");
        if (closingReading<0)
            throw new IllegalArgumentException("A meter reading cannot be negative.");
        if (closingReading<openingReading)
            throw new IllegalArgumentException("Closing reading cannot be below the opening reading.");
        this.openingReading = openingReading;
        this.closingReading = closingReading;
    }
}