package model;

public abstract class AbstractTicket extends LineItem {

    protected final Showtime showtime;
    protected final int row;
    protected final int col;
    protected final double base;


    public AbstractTicket(Showtime showtime, int row, int col) {
        this.showtime = showtime;
        this.row = row;
        this.col = col;
        this.base = showtime.getMovie().getBasePrice();
    }
}
