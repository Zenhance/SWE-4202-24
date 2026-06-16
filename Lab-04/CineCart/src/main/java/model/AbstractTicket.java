package model;

public abstract class AbstractTicket extends LineItem {
    private Showtime showtime;
    private int row;
    private int col;
    protected double base;

    public AbstractTicket(Showtime showtime, int row, int col) {
        this.showtime = showtime;
        this.row = row;
        this.col = col;
        this.base = showtime.getMovie().getBasePrice();
    }

}