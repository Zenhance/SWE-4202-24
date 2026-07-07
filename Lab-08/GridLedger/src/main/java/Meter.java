public class Meter {
    private int openingReading;
    private int closingReading;

    public Meter (int openingReading, int closingReading){
        if(openingReading < 0 || closingReading <0 ){
            throw new IllegalArgumentException("Invalid rating");
        }
        if(closingReading < openingReading){
            throw new IllegalArgumentException("closing reading can't be less than the opening rating");
        }
    }
}
