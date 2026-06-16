package model;

public class StandardTicket extends AbstractTicket {
    public StandardTicket(Showtime showtime, int row, int col){
        super(showtime, row, col);
    }

    @Override
    public double subtotal() {
        return basePrice*peakMultiplier();
    }

    @Override
    public String describe() {
        return "Standard Ticket"+super.describe();
    }
}
