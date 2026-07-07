public class Meter
{
    private int openingReading;
    private int closingReading;

    public Meter(int openingReading, int closingReading)
    {
        if(openingReading<0)
        {
            throw new IllegalArgumentException("Opening Reading has to be positive");
        }
        this.openingReading = openingReading;
        if(closingReading<openingReading)
        {
            throw new IllegalArgumentException("Closing Reading must be greater than or equal to closing reading");
        }
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