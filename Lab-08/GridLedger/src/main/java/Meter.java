package java;

public class Meter {
    private final int  currentReading;
    private final int  previousReading;

    public Meter(int previousReading, int currentReading){
        if(currentReading<0 || previousReading<0){
            throw new IllegalArgumentException("Reading cant be negative.");
        }
        if(currentReading<previousReading){
            throw new IllegalArgumentException("Usages cant be negative");
        }
        this.currentReading = currentReading;
        this.previousReading = previousReading;
    }

    public int getCurrentReading() {
        return currentReading;
    }

    public int getPreviousReading() {
        return previousReading;
    }
    public int totalUsages(){
        return currentReading-previousReading;
    }
}
