package model;


public class Ticket {
    private Showtime showtime;
    private int row;
    private int col;
    private double pricePaid;

    public Ticket(Showtime showtime, int row, int col, double pricePaid){
        this.showtime = showtime;
        this.row = row;
        this.col = col;
        this.pricePaid = pricePaid;
    }

    public Showtime getShowtime() {
        return showtime;
    }

    public double getPricePaid() {
        return pricePaid;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }
}