package model;

public class Ticket {
    private Showtime showtime;
    private int row;
    private int col;
    private double pricePaid;
}

public Ticket{
        this.showtime=showtime;
        this.row=row;
        this.col=col;
        this.pricePaid=pricePaid;}

public Showtime getShowtime(){
    return Showtime;}
public int getRow(){return row;}
public int getCol(){return col;}
public double getPricePaid(){return pricePaid;}

}
public String toString() {
    return String.format(
            "T%d - R%dC%dC%BDT %.2f", showtime.getId(), row, col, pricePaid);}
}

