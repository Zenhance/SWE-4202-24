public class Meter
{
private int openingReading;
private int closingReading;


public Meter (int openingReading,int closingReading) {
    if (closingReading < openingReading)
        throw new IllegalArgumentException(" closing reading below the opening reading is a broken record, not a cheap month");
    if (closeReading < 0) throw new IllegalArgumentException("a negative opening reading is impossible");
    this.openingReading = openingReading;
    this.closingReading = closingReading;
}



    public int getUnitsConsumed() { return closingReading - openingReading; }




}






}