public class Meter {
    private int openingReading;
    private int closingReading;

    public Meter(int openingReading, int closingReading){
        if(openingReading<0 || closingReading<0){
            throw new IllegalArgumentException("Reading can't be negative");
        }
        if(closingReading<openingReading){
            throw new IllegalArgumentException("");
        }
        this.openingReading=openingReading;
        this.closingReading=closingReading;
    }
}
