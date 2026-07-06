package model;

public class StandardTicket extends AbstractTicket {
    public StandardTicket(Showtime showtime, int row, int col){
        super(showtime, row, col);
    }
    public double getPricePaid() {
        double price = getPricePaid();
        boolean peak = getShowtime().isPeak();
        if(peak) return price*1.20;
        return price*1.00;
    }
}
