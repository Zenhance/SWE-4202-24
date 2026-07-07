package main.java;

public class Meter {
    private int openingReading;
    private int closingReading;
    public Meter(int openingReading,int closingReading){
        if(openingReading<0 || closingReading<0){
            throw new IllegalArgumentException("Reading has to be positive");

        }
        if(closingReading<openingReading){
            throw new IllegalArgumentException("Closing reading must be greater or equal than Opening reading");
        }
        this.closingReading=closingReading;
        this.openingReading=openingReading;
    }

    public int getOpeningReading() {
        return openingReading;
    }

    public int getClosingReading() {
        return closingReading;
    }
    public int getUnitConsumed(){
        return closingReading-openingReading;
    }
}
