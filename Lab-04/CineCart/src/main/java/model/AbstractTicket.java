package model;

public abstract class AbstractTicket {
    protected Showtime showtime;
    protected int row;
    protected int col;
    protected double basePrice;

    public AbstractTicket(Showtime showtime, int row, int col, double basePrice){
        this.showtime=showtime;
        this.row=row;
        this.col=col;
        this.basePrice=basePrice;
    }
    public double peak(){
        if(showtime.isPeak()){
            return basePrice*1.20;
        }else{
            return basePrice*1.00;
        }
    }
}
