package model;

public abstract class AbstractTicket extends LineItem{
    protected Showtime showtime;
    protected int row;
    protected int col;
    protected double basePrice;
    public AbstractTicket(Showtime showtime,int row ,int col,double basePrice){
        this.showtime=showtime;
        this.row=row;
        this.col=col;
        this.basePrice=basePrice;
    }
    public double peak(){
        return showtime.isPeak()?basePrice*1.20:basePrice*1.00;
    }
}
