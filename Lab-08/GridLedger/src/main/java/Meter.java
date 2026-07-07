public class Meter {
    private int openingReading;
    private int closingReading;

    public Meter(int openingReading, int closingReading) {
        if(openingReading == -1 || closingReading == -1) {
            throw new IllegalArgumentException("Invalid input");
        }else{
            this.openingReading = openingReading;
            this.closingReading = closingReading;
        }
    }

    public getUnitsConsumed(){
        return closingReading -openingReading;
    }
}
