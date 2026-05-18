package model;

public class Ticket {
    private Showtime showtime;
    private int row;
    private int col;
    private double pricePaid;

    public Ticket(Showtime showtime, int row, int col, double pricePaid){
        this.pricePaid = pricePaid;
        this.showtime = showtime;
        this.col = col;
        this.row = row;
    }

    public Showtime getShowtime() {
        return showtime;
    }

    public double getPricePaid() {
        return pricePaid;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public String toString(){
        return String.format("T%d - R%dC%d @ BDT %.2f",showtime.getId(), row, col, pricePaid);
    }
}
