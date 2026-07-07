public class Meter {

    private int previousReading;
    private int currentReading;

    public Meter(int previousReading,int currentReadingl){
    if(previousReading<0) {throw new IllegalArgumentException("Error!");}
    else  {  this.previousReading=previousReading;}
    if(currentReading<previousReading){
        throw new IllegalArgumentException("Error!");
    }
    else{
        this.currentReading=currentReading;}
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
