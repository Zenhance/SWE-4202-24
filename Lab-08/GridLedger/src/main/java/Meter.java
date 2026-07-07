public class Meter {
    private int previousReading;
    private int currentReading;

    public Meter(int previousReading,int currentReading){
        if(previousReading<0 || currentReading<0){
            throw new IllegalArgumentException("Invalid data");
        }
        if(previousReading>currentReading){
            throw new IllegalArgumentException("Invalid data");
        }

        this.previousReading=previousReading;
        this.currentReading=currentReading;
    }

    public int getPreviousReading(){
        return previousReading;
    }
    public int getCurrentReading(){
        return currentReading;
    }
    public int getUnitsConsumed(){
        return currentReading-previousReading;
    }
}
