package model;

import java.io.LineNumberInputStream;

public abstract class Ticket extends LineItem {
    protected Showtime showtime;
    protected int row;
    protected int col;
    protected double basePrice;
    //constructor
    public Ticket(Showtime showtime, int row, int col, double pricePaid){
        this.showtime=showtime;
        this.row=row;
        this.col=col;
        this.pricePaid=pricePaid;
    }
    //getters
    public Showtime getShowtime() {
        return showtime;
    }
    public int getRow(){
        return row;
    }
    public int getCol(){
        return col;
    }
    public double getPricePaid(){
        return pricePaid;
    }
    public String toString(){
        return "T"+ showtime.getId()+ " - R "+ row + "C"+ col + " @ BDT "+String.format("%.2f",pricePaid);
    }
}
