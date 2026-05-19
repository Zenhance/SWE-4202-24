package model;

public class Ticket {

    private Showtime showtime;

    @Override
    public String toString() {
        return "Ticket{" +
                "showtime=" + showtime +
                ", row=" + row +
                ", col=" + col +
                ", pricePaid=" + pricePaid +
                '}';
    }

    public int getCol() {
        return col;
    }

    public double getPricePaid() {
        return pricePaid;
    }

    public int getRow() {
        return row;
    }

    private int row;
    private int col;
    private double pricePaid;

    Ticket(Showtime showtime, int row, int col, double pricePaid){
    this.Showtime = showtime;
    this.row = row;
    this.col = col;
    this.pricePaid = pricePaid;


    }
    public Showtime getShowtime() {
        return showtime;
    }
}

