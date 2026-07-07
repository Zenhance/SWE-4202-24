package model;

public abstract class Ticket implements LineItem {
    private final Showtime showtime;
    private final int row;
    private final int col;
    private final double basePrice;

    public Ticket(Showtime showtime, int row, int col) {
        this.showtime = showtime;
        this.row = row;
        this.col = col;
        this.basePrice = showtime.getMovie().getBasePrice();
    }

    protected double peakMultiplier(){
        return showtime.isPeak()? 1.20 : 1.00;
    }

    public abstract double subtotal();

    public String describe(){
        return String.format("T%d - R%dC%d", showtime.getId(), row, col);
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


    /*
    public String toString(){
        return String.format("T%d - R%dC%d @ BDT %.2f",
                showtime.getId(), row, col, pricePaid);
    }

     */
}