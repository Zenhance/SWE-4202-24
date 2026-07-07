public class Meter {
private int OpeningReading;
private int ClosingReading;

public Meter(int OpeningReading, int ClosingReading){
    if(OpeningReading<0){
        throw new IllegalArgumentException("Opening reading has to be positive");
    }
    this.OpeningReading=OpeningReading;
    if(ClosingReading<OpeningReading){
        throw new IllegalArgumentException("Closing reading must be greater or equal to opening reading");
    }
    this.ClosingReading=ClosingReading;
}
public int getOpeningReading(){
    return this.OpeningReading;
    }

    public int getClosingReading(){
    return this.ClosingReading;
    }

    public int getUnitsConsumed(){
    return this.ClosingReading-this.OpeningReading;
    }
}
