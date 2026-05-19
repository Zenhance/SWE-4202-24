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

    public Showtime getShowtime() {
        return showtime;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public double getPricepaid() {
        return pricepaid;
    }
    public String toString(){
        return "T"+
                showtime.getId()
                +" - R"+
                row+
                "C"+
                col+
                " @ BDT "+
                String.format("%.2f",pricepaid);
    }
}