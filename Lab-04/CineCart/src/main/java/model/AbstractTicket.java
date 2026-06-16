package model;

public abstract class AbstractTicket extends LineItem {
    protected Showtime showtime;
    protected int row;
    protected int col;
    protected double basePrice;
public AbstractTicket(Showtime showtime,int cols,int rows){
    this.showtime=showtime;
    this.col=col;
    this.row=row;
    this.basePrice=basePrice;

    }
    public double peak(){
    return showtime.isPeak()?basePrice*1.20:basePrice*1.00;
    }
}
