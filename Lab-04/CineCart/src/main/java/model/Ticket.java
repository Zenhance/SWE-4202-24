package model;

public class Ticket {
    Showtime showtime;
    int row,col;
    double pricePaid;
    public Ticket(Showtime showtime, int row, int col, double pricePaid) {
        this.showtime=showtime;
        this.row=row;
        this.col=col;
        this.pricePaid=pricePaid;
    }



    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public Showtime getShowtime() {
        return showtime;
    }

    public double getPricePaid() {
        return pricePaid;
    }


    public String toString() {
        return String.format("T%d - R%dC%d @ BDT %.2f",showtime.getId(),row,col,pricePaid);
    }
}
