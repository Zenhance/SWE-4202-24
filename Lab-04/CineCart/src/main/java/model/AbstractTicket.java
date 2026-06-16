package model;

public abstract class AbstractTicket extends LineItem {
    protected Showtime showtime;
    protected int row;
    protected int col;
    protected double basePrice;

    public AbstractTicket(Showtime showtime ,int row,int col,double basePrice){
        this.showtime=showtime;
        this.row=ro;
        this.col=col;
        this.basePrice=basePrice;
    }
    protected double getPeakMultiplier(){
        return 1.00;
    }
    @Override
    public boolean isTicket(){
        return true;
    }

}
