package model;

public class Ticket {
    Showtime showtime; int row; int col; double pricePaid;
    public Ticket(Showtime showtime, int row, int col, double pricePaid){
        this.showtime=showtime;
        this.row=row;
        this.col=col;
        this.pricePaid=pricePaid;
    }
    Showtime getShowtime(){
        return showtime;
    }
    int getRow(){
        return row;
    }
    int getCol(){
        return col;
    }
    double getPricePaid(){
        return pricePaid;
    }
    public String toString(){
        return String.format("T%d - R%dC%d @ BDT %.2f", showtime.getId(), row,col,pricePaid);
    }
}
