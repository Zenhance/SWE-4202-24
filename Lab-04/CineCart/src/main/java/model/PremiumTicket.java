package model;

public abstract class PremiumTicket extends AbstractTicket{
    PremiumTicket(Showtime showtime,int row, int col) {
        super();
    }

    public double subtotal(){
        return 0.0;
    }

    public String describe() {
        return null;
    }
}
