public class Meter {
    private int openingReading;
    private int closingReading;
    public Meter(int openingReading,int closingReading){
        if (openingReading<0 || closingReading<0){
            throw new IllegalArgumentException("Reading cannot be negative");
        }
        if (openingReading>closingReading){
            throw new IllegalArgumentException("Closing reading cannot be smaller than opening reading");
        }


    }
}
