package model;

public class VIPTicket extends PremiumTicket {
    public VIPTicket(Showtime showtime, int row, int col) {
        super(showtime, row, col);
    }

    public double subtotal() {
        return 0.0;
    }


    public String describe() {
        return "";
    }
}