package model;

public class PremiumTicket extends Ticket {

    public PremiumTicket(Showtime showtime,
                         int row,
                         int col) {

        super(showtime, row, col);
    }


    public double subtotal() {
        return basePrice * 1.30 * peakMultiplier();
    }


    public String describe() {
        return super.describe() + " Premium";
    }
}
