package model;

public abstract class Ticket implements LineItem {
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

    public Showtime getShowtime(){
        return showtime;
    }

    public int getRow(){
        return row;
    }

    public int getCol(){
        return col;
    }

    public double getPricePaid(){
        return subtotal();
    }

    protected double peakMultiplier() {
        return showtime.isPeak() ? 1.20 : 1.00;
    }

    @Override
    public boolean isTicketLine() {
        return true;
    }

    @Override
    public String describe() {
        return "T" + showtime.getId() + " - R" + row + "C" + col
                + " @ BDT " + String.format("%.2f", subtotal());
    }

    @Override
    public String toString() {
        return describe();
    }
}
