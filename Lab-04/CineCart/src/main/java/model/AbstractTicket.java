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
    public Showtime getShowtime() { return showtime; }
    public int getRow()           { return row; }
    public int getCol()           { return col; }


    protected double peakMultiplier() {
        if (showtime.isPeak()) {
            return 1.20;
        } else {
            return 1.00;
        }
    }


    @Override
    public String describe() {
        return "T" + showtime.getId() + " - R" + row + "C" + col;
    }

}
