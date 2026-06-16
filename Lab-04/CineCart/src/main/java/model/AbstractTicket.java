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

    public Showtime getShowtime() {
        return showtime;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    protected double calculateBase() {
        double price = showtime.getMovie().getBasePrice();
        if (showtime.isPeak()) {
            price *= 1.20;
        }
        return price;
    }


}