package model;

public abstract class Ticket extends lineItem {
    protected Showtime showtime;
    protected int row;
    protected int col;
    protected double base;

    public Ticket(Showtime showtime, int row, int col) {
        this.showtime = showtime;
        this.row = row;
        this.col = col;
        this.base = showtime.getMovie().getBasePrice();

    }

    public Showtime getShowtime() {
        return showtime;
    }



    public double getPricePaid() {
        return base;
    }
    public double peakTime()
    {
        if(showtime.isPeak())
        {
            base=base*1.20;
        }
        return base;
    }
}
