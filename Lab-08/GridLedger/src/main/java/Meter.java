public class Meter {
    private final int openingReading;
    private final int closingReading;

    public Meter(int openingReading, int closingReading){
    if(openingReading < 0 || closingReading < 0){
        throw new IllegalArgumentException("It can't be negative.");
    }
    if(closingReading < openingReading){
        throw new IllegalArgumentException("Closing reading must be greater than oepning reading.");
    }
    this.openingReading = openingReading;
    this.closingReading = closingReading;
    }

    public int getOpeningReading(){
        return openingReading;
    }

    public int getClosingReading(){
        return closingReading;
    }

    public int getUnitsConsumed() {
        return (getClosingReading() - getOpeningReading());
    }
}
