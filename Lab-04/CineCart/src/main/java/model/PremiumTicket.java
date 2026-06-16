package model;

public class PremiumTicket extends AbstractTicket {
    public PremiumTicket(Showtime showtime, int row, int col) {
        super(showtime, row, col);
    }

    @Override
    public double subtotal() {
        return (getShowtime().isPeak() ? 350.00 * 1.30 * 1.20 : 200.00 * 1.30);
    }

    @Override
    public String describe() {
        String string = String.format("Premium\n" +
                "subtotal : %f BDT", subtotal());

        return string;
    }
}
