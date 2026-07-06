package model;

public abstract class AbstractTicket extends LineItem {
    private final Showtime  showtime;
    private final int row;
    private final int col;
    //private final double pricePaid;

    public AbstractTicket(Showtime showtime, int row, int col) {
        this.showtime = showtime;
        this.row = row;
        this.col = col;
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

    public double subtotal() {
        return showtime.getMovie().getBasePrice();
    }
    public String describe() {
        String out = String.format("T%d - R%dC%d @ BDT %.2f", showtime.getId(), row, col);
        return out;
    }
}
