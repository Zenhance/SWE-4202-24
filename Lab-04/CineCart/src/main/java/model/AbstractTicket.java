package model;

public abstract class AbstractTicket extends LineItem{
    public Showtime showtime;
    public int row;
    public int col;
    public double base=0;
    public AbstractTicket(Showtime showtime,int row,int col){

        this.showtime=showtime;
        this.col=col;
        this.row=row;
        this.base=base;
    }



}
