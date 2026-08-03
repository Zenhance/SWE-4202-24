package model;

public class PremiumTicket extends AbstractTicket{
    public PremiumTicket(Showtime showtime, int i, int i1) {
        super(showtime, i, i1);
    }

    public double subtotal() {
        return 1220;
    }

    public String describe() {
        return " ";
    }
}
