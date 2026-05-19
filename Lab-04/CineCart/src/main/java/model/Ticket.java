package model;

public class Ticket {
    //Showtime showtime, int row, int col, double pricePaid.
    private final Showtime showtime;
    private final int row;
    private final int col;
    private final double pricePaid;

    public Ticket(Showtime showtime, int row, int col, double pricePaid){
        this.showtime = showtime;
        this.row = row;
        this.col = col;
        this.pricePaid = pricePaid;
    }

    public Showtime getShowtime(){
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
    //"T17 - R3C5 @ BDT 455.00".
    public String toString(){
        return String.format("T%d - R%dC%d @ BDT %f",showtime.getId(),row,col,pricePaid);
    }
}
