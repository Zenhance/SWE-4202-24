package model;

public class StandardTicket extends Ticket {
    public StandardTicket(Showtime showtime, int row, int col, double pricePaid){
        super(showtime, row, col, pricePaid);
    }
    public double getPricePaid() {
        double price = getPricePaid();
        boolean peak = getShowtime().isPeak();
        if(peak) return price*1.20;
        return price*1.00;
    }
}
