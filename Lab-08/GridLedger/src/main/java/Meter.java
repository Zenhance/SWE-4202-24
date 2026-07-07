public class Meter{
    private final int openingReading;
    private final int closingReading;

    public Meter(int openingReading, int closingReading){
        if(openingReading<0 || closingReading<0){
            throw new IllegalArgumentException("Readings cannot be negative");

        }
        if(closingReading<openingReading){
            throw new IllegalArgumentException("Closing reading cannot be smaller than openning reading");
        }
        this.closingReading=closingReading;
        this.openingReading=openingReading;
    }
    public int getOpeningReading(){
        return openingReading;
    }
 public int getClosingReading(){
        return closingReading;
 }
    public int getUnitsConsumed(){
        return closingReading-openingReading;
    }
}
