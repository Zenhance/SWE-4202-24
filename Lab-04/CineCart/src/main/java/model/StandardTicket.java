package model;

public class StandardTicket extends AbstractTicket{
    public StandardTicket(Showtime showtime, int row, int col) {
        super(showtime, row, col);
    }

    @Override
    public double subtotal() {
        return (getShowtime().isPeak() ? 350.00 * 1.20 : 200.0);
    }
}
