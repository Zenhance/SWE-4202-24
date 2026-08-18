public class Meter {
    private int openingReading;
    private int closingReading;

    public Meter(int openingReading, int closingReading){
       //A meter never runs backwards. A closing reading below the opening reading is not a cheap month; it
        //is a broken record, and the system must refuse it rather than bill a negative quantity. A reading
        //itself can never be negative.
        if(openingReading < 0 || closingReading < 0){
            throw new IllegalArgumentException("Meter can't be negative");
        }
        if(closingReading < openingReading){
            throw new IllegalArgumentException("closing can't be smaller than opening");
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

    public int getUnitsConsumed(){
        return closingReading - openingReading;
    }


}
