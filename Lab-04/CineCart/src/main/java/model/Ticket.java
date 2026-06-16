package model;

public abstract class Ticket extends LineItem {
    protected Showtime showtime;
    protected int row;
    protected int col;
    protected double basePrice;

    public Ticket(Showtime showtime, int row, int col) {
        this.showtime = showtime;
        this.row = row;
        this.col = col;
        this.basePrice = showtime.getMovie().getBasePrice();
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

    public double getPricePaid() {
        return basePrice;
    }

    protected double peakMultiplier() {
        if (showtime.isPeak()) {
            return 1.20;
        }

        return 1.00;
    }

    public boolean ticketLine() {
        return true;
    }

    @Override
    public String describe() {
        return "T" + showtime.getId() + " - R" + row + "C" + col
                + " @ BDT " + String.format("%.2f", getPricePaid());
    }

    @Override
    public String toString() {
        return describe();
    }
}