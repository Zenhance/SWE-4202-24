package model;

public class StudentTicket extends AbstractTicket {
    public StudentTicket(Showtime showtime, int row, int col){
        super(showtime, row, col);
    }
    public double getPricePaid() {
        double price = getPricePaid() * 0.50;
        boolean peak = getShowtime().isPeak();
        if(peak) return price*1.20;
        return price*1.00;
    }
}