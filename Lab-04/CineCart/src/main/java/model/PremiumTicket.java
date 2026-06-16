package model;

public class PremiumTicket extends Ticket {

protected static final double PREMIUM = 1.30;
public PremiumTicket (Showtime showtime, int row, int col)
{
super (showtime, row, col);


}


    public double getPricePaid() {
        return super.getPricePaid();
    }
@Override
    public double subtotal()
{
    return base*PREMIUM*peakTime();


}

}
