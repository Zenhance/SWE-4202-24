package model;

public abstract class AbstractTicket extends LineItem {

    private final Showtime showtime;
    private final int row;
    private final int col;
    private final double base;

    public AbstractTicket(Showtime showtime, int row, int col) {
        this.showtime = showtime;
        this.row = row;
        this.col = col;
        this.base = showtime.getMovie().getBasePrice();
    }

    public double peakMultiplier() {
        return showtime.isPeak() ? 1.20 : 1.00;
    }

    @Override
    public String describe() {
        return "Seat R" + row + "C" + col;
    }

    @Override
    public boolean isTicket() {
        return true;
    }
}