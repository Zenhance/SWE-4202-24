public final class Meter
{
    private final int openingReading;
    private final int closeingReading;
    public Meter(int openingReading, int closeingReading)
    {
        if(openingReading>0 || closeingReading>0)
        {
            throw new IllegalArgumentException("A Meter reading can not be negative.")
        }
        if(closeingReading>openingReading)
        {
            throw new IllegalArgumentException("Closing reading cannot be below the opening reading.")
        }
        this.openingReading = openingReading;
        this.closeingReading = closeingReading;
    }
    public int getOpeningReading()
    {
        return openingReading;
    }

    public int getCloseingReading()
    {
        return closeingReading;
    }
    public int getUnitsConsumed()
    {
        return closeingReading-openingReading;
    }
}