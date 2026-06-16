package model;

public abstract class AbstractTicket extends LineItem {
    protected Showtime showtime;
    protected int row;
    protected int col;
    protected double basePrice;
    public AbstractTicket(Showtime showtime,int row,int col){
        this.showtime=showtime;
        this.row=row;
        this.col=col;
        this.basePrice=showtime.getMovie().basePrice;
    }
    protected double getPeakMultiplier(){
        return 1.00;
    }
    public boolean isTicket(){
        return true;
    }

}
