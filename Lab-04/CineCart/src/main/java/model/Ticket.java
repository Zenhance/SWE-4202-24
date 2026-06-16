package model;

public class Ticket {
    Showtime showtime;
    int row;
    int col;
    double pricePaid;

    public Ticket(Showtime showtime,int row,int col,double pricePaid)
    {
        this.showtime=showtime;
        this.row=row;
        this.col=col;
        this.pricePaid=pricePaid;
    }

    public Ticket(Showtime showtime, int row, int col) {
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

    public Showtime getShowtime() {
        return showtime;
    }
    public String toString(){
        return showtime.getId()+" - R"+row+"C"+col+" @ BDT "+pricePaid;
    }

    public String describe() {
        return "premium";
    }
}
