package model;

public class Ticket {
    private Showtime showtime;
    private int row;
    private int col;
    private double pricepaid;

    public Ticket(Showtime showtime, int row, int col, double pricepaid) {
        this.showtime = showtime;
        this.row = row;
        this.col = col;
        this.pricepaid = pricepaid;
    }
}