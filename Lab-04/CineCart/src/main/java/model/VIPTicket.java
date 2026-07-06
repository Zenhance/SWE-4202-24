package model;

public class VIPTicket extends PremiumTicket
{
    protected static final double FLAT_LOUNGE = 200.00;

    public VIPTicket(Showtime showtime, int row, int col)
    {
        super(showtime, row, col);
    }

    @Override
    public double subtotal()
    {
        return super.subtotal()+FLAT_LOUNGE;
    }

    @Override
    public String describe()
    {
        return super.describe()+" VIP Lounge";
    }
}