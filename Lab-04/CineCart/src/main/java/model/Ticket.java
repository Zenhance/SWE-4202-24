package model;

public class Ticket {
    private Showtime showtime;
    private int row;
    private int col;
    private double pricePaid;
    //constructor
    public Ticket{
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
}
