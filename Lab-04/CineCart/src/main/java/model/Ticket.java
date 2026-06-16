package model;

import java.io.LineNumberInputStream;

public abstract class Ticket extends LineItem {
    protected Showtime showtime;
    protected int row;
    protected int col;
    protected double basePrice;
    //constructor
    public Ticket(Showtime showtime, int row, int col){
        this.showtime=showtime;
        this.row=row;
        this.col=col;
        this.basePrice=showtime.getBasePrice();
    }
    protected double peakMultiplier(){
    return showtime.isPeak() ? 1.20 : 1.00;
    }
    @Override
    public boolean isTicket(){
        return true;
    }
    @Override
    public String describe(){}
    return "Seat(" + row + "," + col + ")";
}