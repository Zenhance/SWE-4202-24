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
    this.base = Showtime.getMovie().getBasePrice();
}



}
