package model;

public class VIPTicket extends PremiumTicket{
    public VIPTicket(Showtime showtime, int row, int col) {
        super(showtime, row, col);
    }

    @Override
    public double subtotal() {
        return super.subtotal() + 200.00;
    }

    @Override
    public String describe() {
        String string = String.format("VIP\n" +
                "Premium\n" +
                "subtotal : %f BDT", subtotal());

        return string;
    }
}
