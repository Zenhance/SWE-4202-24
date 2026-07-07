public class Meter{
    public final int openingReading;
    public final int closingReading;

    public Meter(int openingReading, int closingReading){
        if (openingReading<0)
            throw new IllegalArgumentException("A meter readingcannot be negative.");
        if (closingReading<0)
            throw new IllegalArgumentException("A meter readingcannot be negative.");
    }
}