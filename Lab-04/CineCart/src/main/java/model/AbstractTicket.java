package model;

public abstract class AbstractTicket extends LineItem {

    protected Showtime base;
    protected int row;
    protected int col;

    public AbstractTicket(Showtime base, int row, int col) {
        this.base = base;
        this.row = row;
        this.col = col;
    }

    public Showtime getShowtime() {
        return base;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

}