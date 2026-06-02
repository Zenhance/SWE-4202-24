package model;

public class Ticket {
    Showtime showtime;
    int row;
    int col;
    double pricePaid;
    public Ticket( Showtime showtime, int row, int col, double pricePaid){
        this.showtime=showtime;
        this.row=row;
        this.col=col;
        this.pricePaid=pricePaid;
    }

    public Showtime getShowtime() {
        return showtime;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public double getPricePaid() {
        return pricePaid;
    }

    @Override
    public String toString() {
        return "Ticket["+showtime.getMovie().getTitle()+" | Row"+row+" Col"+col+" | BDT"+String.format("%.2f",pricePaid)+"]";
    }
}
