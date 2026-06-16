package model;

public class StandardTicket extends AbstractTicket{
    public StandardTicket(Showtime showtime, int row, int col){
        super(showtime, row, col);
    }

    public double subtotal(){
        if (getShowtime().isPeak())
            return 350.00 * 0.50;
        else return 200.00 ;
    }
}
