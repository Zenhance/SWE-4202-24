package model;

public abstract class AbstractTicket extends LineItem {
    protected Showtime showtime;
    protected int rows;
    protected int cols;
    protected double basePrice;
public AbstractTicket(Showtime showtime,int cols,int rows){
    this.showtime=showtime;
    this.cols=cols;
    this.rows=rows;
    }
    public double peak(){
    return showtime.isPeak()?basePrice*1.20:basePrice*1.00;
    }
}
