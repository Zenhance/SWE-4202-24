package model;

public abstract class AbstractTicket extends LineItem{

protected double base;
private Showtime showtime;
private int row;
private int col;


public AbstractTicket(Showtime showtime , int row , int col){


    this.showtime = showtime;
    this.row = row;
    this.col = col;
    this.base = showtime.getMovie().getBasePrice();
}

    protected double peakMultiplier(){
        return showtime.isPeak() ? 1.20 : 1.0;
    }

    @Override
    public boolean isTicket(){
        return true;
    }

    @Override
    public String describe(){
        return "Seat(" + row + "," + col + ")";
    }


}
