package model;

public abstract class Ticket extends LineItem {
    Showtime showtime;
    int row;
    int col;
    double base;

    public Ticket(Showtime showtime, int row, int col, double pricePaid){
        this.showtime=showtime;
        this.row=row;
        this.col=col;
        this.base=showtime.getMovie().getBasePrice();
    }

    public Showtime getShowtime() {
        return showtime;
    }

    public int getRow(){
        return row;
    }

    public int getCol() {
        return col;
    }

    public double getPricePaid() {
        return pricePaid;
    }


    public String toString() {
        return String.format("T%d - R%dC%d @ BDT %.2f",showtime.getId(),row,col,pricePaid);
    }
}
