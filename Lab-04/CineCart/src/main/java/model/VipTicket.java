package model;

public class VipTicket extends PremiumTicket
{
    protected static final double FLAT_LOUNGE = 200.00;

    public VipTicket(Showtime showtime, int row, int col)
    {
        super(showtime, row, col);
    }

    @Override
    public double subTotal()
    {
        return super.subTotal()+FLAT_LOUNGE;
    }
}