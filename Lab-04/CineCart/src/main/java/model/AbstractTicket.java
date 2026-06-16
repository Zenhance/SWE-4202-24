package model;

public abstract class AbstractTicket extends LineItem {
    private final Showtime showtime;
    private final int row;
    private final int col;
    private double pricePaid;

    public AbstractTicket(Showtime showtime, int row, int col, double pricePaid) {
        super(pricePaid);
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

    public double getPricePaid() {
        return pricePaid;
    }

    public String toString() {
        String string = String.format("T%d - R%dC%d @ BDT %.2f", showtime.getId(),
                    row, col, pricePaid);

        return string;
    }
}
