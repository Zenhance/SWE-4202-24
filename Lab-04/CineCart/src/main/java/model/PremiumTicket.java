package model;

public class PremiumTicket extends AbstractTicket
{
    protected static final double PREMIUM = 1.30;

    public PremiumTicket(Showtime showtime, int row, int col)
    {
        super(showtime, row, col);
    }

    @Override
    public double subtotal()
    {
        return PREMIUM*peakTime();
    }

    @Override
    public String describe()
    {
        return super.describe()+" Premium";
    }
}