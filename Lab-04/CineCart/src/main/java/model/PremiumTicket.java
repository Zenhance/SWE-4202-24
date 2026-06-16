package model;

public class PremiumTicket extends AbstractTicket{

    public PremiumTicket(Showtime showtime, int row, int col) {
        super(showtime, row, col);
    }

    public double subtotal() {
        return getBase() * 1.30 * isPeak();
    }


}
