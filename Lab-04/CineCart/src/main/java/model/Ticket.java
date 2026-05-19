package model;

public class Ticket {
    private Showtime showtime;
    private int row;
    private int col;
    private double pricePaid;

    public Ticket(Showtime showtime, int row, int col, double pricePaid){
        this.showtime=showtime;
        this.row=row;
        this.col=col;
        this.pricePaid=pricePaid;
    }
    public Showtime getShowtime(){
        return this.showtime;
    }
    public int getRow(){
        return this.row;
    }
    public int getCol(){
        return this.col;
    }
    public double getPricePaid(){
        return this.pricePaid;
    }

}
