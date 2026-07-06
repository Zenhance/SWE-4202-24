package model;

public class PremiumTicket extends AbstractTicket {
    public PremiumTicket(Showtime showtime, int row, int col){
        super(showtime, row, col);
    }
    public double subtotal() {
        double price = super.subtotal() * 1.30;
        boolean peak = getShowtime().isPeak();
        if(peak) return price*1.20;
        return price*1.00;
    }
}
