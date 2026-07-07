public class Meter {
    private final int openingReading;
    private final int closingReading;

    public Meter(int openingReading,int closingReading){
        if(openingReading<0||closingReading<0){
            throw new IllegalAccessException("Reading cannot be negative");
        }
        if(closingReading<openingReading){

        }
    }
}
