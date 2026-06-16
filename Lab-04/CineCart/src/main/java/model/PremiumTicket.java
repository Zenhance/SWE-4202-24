package model;

public class PremiumTicket extends AbstractTicket {
    public PremiumTicket(Showtime showtime, int row, int col) {
        super(showtime, row, col);
    }

    @Override
    public double subtotal() {
        return calculateBase() * 1.30;
    }
}