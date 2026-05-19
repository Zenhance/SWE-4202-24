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
        return Showtime;
    }
    public int getRow(){
        return row;
    }
}
