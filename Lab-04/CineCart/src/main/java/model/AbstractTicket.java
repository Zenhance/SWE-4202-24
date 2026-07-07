package model;

public abstract class AbstractTicket extends LineItem {

    protected double base;
    protected Showtime showtime;
    protected int row;
    protected int seat;

    public AbstractTicket(Showtime showtime, int row, int seat) {
        this.showtime = showtime;
        this.row = row;
        this.seat = seat;
        this.base = showtime.getMovie().getBasePrice();
    }

    public Showtime getShowtime() {
        return showtime;
    }

    public int getRow() {
        return row;
    }

    public int getSeat() {
        return seat;
    }

    @Override
    public abstract double subtotal();

    @Override
    public abstract String describe();
}
