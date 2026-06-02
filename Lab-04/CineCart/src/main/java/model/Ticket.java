package model;

// Fields: Showtime showtime, int row, int col, double pricePaid.

public class Ticket {

    private Showtime showtime;
    private int row;
    private int col;
    private double pricePaid;

    //Constructor: four-argument full constructor

    public Ticket(Showtime showtime, int row, int col, double pricePaid) {
        this.showtime = showtime;
        this.row = row;
        this.col = col;
        this.pricePaid = pricePaid;
    }

    // Methods: getters; toString() e.g. "T17 - R3C5 @ BDT 455.00".

    public Showtime getShowtime() {
        return showtime;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public double getPricePaid() {
        return pricePaid;
    }

    public String toString() {
        return String.format("T%d - R%dC%d @ BDT %.2f",
                showtime.getId(), row, col, pricePaid);
    }

}
