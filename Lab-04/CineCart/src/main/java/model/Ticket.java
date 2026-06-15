package model;

public class Ticket {
    Showtime showtime;
    int row;
    int col;
    double pricePaid;

    public Ticket(Showtime showtime, int row, int col, double pricePaid) {
        this.showtime = showtime;
        this.col = col;
        this.row = row;
        this.pricePaid = pricePaid;
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
        return String.format("T - %d%d @ BDT %.2lf", showtime, row, col, pricePaid);
    }
}
