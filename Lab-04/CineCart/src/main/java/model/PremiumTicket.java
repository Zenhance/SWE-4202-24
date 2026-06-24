package model;

public class PremiumTicket extends AbstractTicket{
    public PremiumTicket(Showtime showtime, int row, int col) {
        super(showtime,row,col);
    }

    public double subtotal() {
        return 0;
    }

    public String describe() {
        return null;
    }
}
