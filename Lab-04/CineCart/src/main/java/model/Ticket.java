package model;

public abstract class Ticket extends LineItem {
    private final Showtime  showtime;
    private final int row;
    private final int col;
    private final double pricePaid;

    public Ticket(Showtime showtime, int row, int col, double pricePaid) {
        this.showtime = showtime;
        this.row = row;
        this.col = col;
        this.pricePaid = pricePaid;
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
        return pricePaid;
    }
    public String toString() {
        String out = String.format("T%d - R%dC%d @ BDT %.2f", showtime.getId(), row, col, pricePaid);
        return out;
    }
}
