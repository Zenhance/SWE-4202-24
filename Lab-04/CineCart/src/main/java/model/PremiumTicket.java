package model;

public class PremiumTicket extends AbstractTicket{
    public PremiumTicket(Showtime showtime, int row, int col){
        super(showtime, row, col);
    }

    @Override
    public double subtotal() {
        return basePrice*peakMultiplier()*1.30;
    }

    @Override
    public String describe() {
        return "Premium Ticket"+super.describe();
    }
}
