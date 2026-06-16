package model;

public abstract  class AbstractTicket extends LineItem {

    protected final Showtime showtime;
    protected final int row;
    protected final int col;
    protected final double basePrice;


    protected AbstractTicket(Showtime showtime, int row, int col){
        this.showtime = showtime;
        this.row = row;
        this.col = col;
        this.basePrice = showtime.getMovie().getBasePrice();
    }

    protected double peakMultiplier(){
        return (showtime.isPeak()?1.20:1.00);
    }
}
