package model;

public abstract class Ticket extends LineItem{
    protected Showtime showtime;
    protected int row;
    protected int col;
    protected double pricePaid;

    protected Ticket(Showtime showtime, int row, int col, double pricePaid) {
        this.showtime = showtime;
        this.row = row;
        this.col = col;
        this.pricePaid = showtime.getMovie().getBasePrice();
    }
    protected double peakFactor(){
        return showtime.isPeak()?1.20: 1.00;
    }
    public Showtime getShowtime() {
        return showtime;

    }
    public int getRow(){
        return row;
    }

    public int getCol(){
       return col;
    }

    public boolean isTicket(){
        return true;
    }

    public String describe(){
        return showtime.toString()+ " - R" + row + "C" + col;
    }

}
