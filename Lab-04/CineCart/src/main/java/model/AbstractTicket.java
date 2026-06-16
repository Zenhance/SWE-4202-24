package model;

public class AbstractTicket { Showtime showtime;
    int row;
    int col;
    double pricePaid;

    public AbstractTicket()
    {
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

    public double getPricePaid() {
        return pricePaid;
    }

    public Showtime getShowtime() {
        return showtime;
    }
    public String toString(){
        return showtime.getId()+" - R"+row+"C"+col+" @ BDT "+pricePaid;
    }
}


