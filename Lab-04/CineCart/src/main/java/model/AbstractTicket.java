package model;

public abstract class AbstractTicket extends LineItem {
    protected double base;
    protected Showtime showtime;
    protected int row;
    protected int col;

    public AbstractTicket(Showtime showtime, int row, int col) {
        this.showtime = showtime;
        this.row = row;
        this.col = col;


    }
}