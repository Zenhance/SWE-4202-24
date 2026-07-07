public class Meter
{
    private int openingReading;
    private int closingReading;

    public Meter(int openingReading, int closingReading)
    {
        this.openingReading = openingReading;
        this.closingReading = closingReading;
    }

    public int getOpeningReading()
    {
        return openingReading;
    }

    public int getClosingReading()
    {
        return closingReading;
    }

    public int getUnitsConsumed()
    {
        return closingReading-openingReading;
    }
}