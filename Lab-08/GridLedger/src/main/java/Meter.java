package main.java;

public class Meter {
    private int openingReading;
    private int closingReading;
    public Meter(int openingReading,int closingReading){
        if(closingReading<openingReading) {
            throw new IllegalArgumentException("Closing Reading can not be greater than Opening Reading");
        }
        if(openingReading<0){
                throw new IllegalArgumentException("Opening Reading can not be negative");
            }
        if(closingReading<0){
            throw new IllegalArgumentException("Closing Reading can not be negative");
    }
        this.openingReading=openingReading;
        this.closingReading=closingReading;

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
