package model;

public class PremiumTicket extends Ticket
{
    protected static final double PREMIUM = 1.30;

    public PremiumTicket(Showtime showtime, int row, int col)
    {
        super(showtime, row, col);
    }

    @Override
    public double subTotal()
    {
        return base*PREMIUM*peakTime();
    }
}