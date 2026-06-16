package model;

public abstract class AbstractTicket {
    private Showtime showtime;
    private int row;
    private int col;
    private double pricePaid;

    public AbstractTicket(Showtime showtime, int row, int col, double pricePaid){
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

    public String toString(){
        return "T" + showtime.getId() + " - R" + row + "C" + col + " @ BDT " + String.format("%.2f", pricePaid);
    }

}
