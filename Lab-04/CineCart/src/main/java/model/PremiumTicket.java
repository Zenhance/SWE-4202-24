package model;

public class PremiumTicket extends AbstractTicket {

    private static final double PREMIUM_MULTIPLIER = 1.30;

    public PremiumTicket(Showtime showtime, int row, int col) {

        super(showtime, row, col);
    }

    @Override
    public double subtotal() {

        return base * PREMIUM_MULTIPLIER * peakMultiplier();
    }
}
