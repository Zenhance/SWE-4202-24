package model;

public class Ticket {
    private Showtime showtime;
    private int row;
    private int col;
    private double pricePaid;

    Constructor(Showtime showtime,int row,int col,double pricePaid) {
            this.showtime=showtime;
            this.row=row;
            this.col=col;
            this.pricePaid=pricePaid;
    }
}
