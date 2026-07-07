
public class Meter {
    private final int openingReading;
    private final int closingReading;
    public Meter(int openingReading,int closingReading){
        if(openingReading <0|| closingReading<0){
            throw new IllegalArgumentException("Can not be negative");
        }
        if(closingReading<openingReading){
            throw new IllegalArgumentException("Error");
        }
        this.openingReading=openingReading;
        this.closingReading=closingReading;
    }
    public int getOpeningReading(){
        return openingReading;
    }

    public int getClosingReading() {
        return closingReading;
    }
    public int getUnitsConsumed(){
        return closingReading-openingReading;
    }


}
