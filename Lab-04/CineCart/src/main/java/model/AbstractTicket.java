package model;

public abstract class AbstractTicket extends LineItem{
    protected final Showtime showtime;
    protected final int row;
    protected final int col;
    protected final double base;

    public AbstractTicket(Showtime showtime, int row, int col){
        this.showtime = showtime;
        this.row = row;
        this.col = col;
        this.base = showtime.getMovie().getBasePrice();
    }

    protected double peakMultiplier(){
        return showtime.isPeak()?1.20:1.00;
    }
    @Override
    public boolean isTicket(){
        re
    }
}
