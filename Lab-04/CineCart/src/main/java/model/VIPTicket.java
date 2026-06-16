package model;


public class VIPTicket extends PremiumTicket {

    private static final double LOUNGE_CHARGE = 200.00;

    public VIPTicket(Showtime showtime, int row, int col) {
        super(showtime, row, col);
    }

    @Override
    public double subtotal() {

        return super.subtotal() + LOUNGE_CHARGE;
    }

}
