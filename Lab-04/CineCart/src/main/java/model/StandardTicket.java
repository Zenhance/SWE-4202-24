package model;


public class StandardTicket extends AbstractTicket{

    public StandardTicket(Showtime showtime, int row, int col) {
        super(showtime,row,col);

    }

    public double subtotal() {
        return 0.0;
    }

    public String describe() {
        return null;
    }

}
