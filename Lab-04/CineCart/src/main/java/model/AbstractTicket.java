package model;

public abstract  class AbstractTicket extends LineItem {

    private final Showtime showtime;
    private final int row;
    private final int col;
    private final double basePrice;


    public AbstractTicket(Showtime showtime, int row, int col){
        this.showtime = showtime;
        this.row = row;
        this.col = col;
        this.basePrice = showtime.getMovie().getBasePrice();
    }

    public double peakMultiplier(){
        return (showtime.isPeak()?1.20:1.00);
    }
}
