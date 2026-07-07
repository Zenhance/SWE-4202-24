package model;

public class VIPTicket extends PremiumTicket {

    public VIPTicket(Showtime showtime, int row, int seat) {
        super(showtime, row, seat);
    }

    @Override
    public double subtotal() {
        return super.subtotal() + 200.0;
    }

    @Override
    public String describe() {
        return super.describe() + " + VIP Lounge Access";
    }
}