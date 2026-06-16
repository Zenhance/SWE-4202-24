package model;

public class PremiumTicket extends Ticket {
    public PremiumTicket(Showtime showtime, int row, int col, double pricePaid){
        super(showtime, row, col, pricePaid);
    }
    public double getPricePaid() {
        double price = getPricePaid() * 1.30;
        boolean peak = getShowtime().isPeak();
        if(peak) return price*1.20;
        return price*1.00;
    }
}
