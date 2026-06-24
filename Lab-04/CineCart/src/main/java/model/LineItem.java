package model;

public abstract class LineItem extends StandardTicket{

    public StandardTicket(Showtime showtime, int row, int col) {
        super(showtime,row,col);

    }
    public double subtotal() {
        return 0;
    }

    public boolean hasCode(String pop) {
        return false;
    }

}
