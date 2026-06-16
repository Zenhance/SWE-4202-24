package model;

public abstract class AbstractTicket extends LineItem {
    protected double base;
    protected Showtime showtime;
    protected int row;
    protected int col;

    public AbstractTicket(Showtime showtime, int row, int col) {
        this.showtime = showtime;
        this.row = row;
        this.col = col;



        double peakMultiplier = 1.00;


        if ("Fri".equalsIgnoreCase(showtime.getDay())) {

            peakMultiplier = 1.20;

        } else {

            peakMultiplier = 1.00;
        }


        double moviePrice = showtime.getMovie().getBasePrice();


        this.base = moviePrice * peakMultiplier;
    }

    public Showtime getShowtime() {
        return showtime;
    }


    public boolean isTicket() {
        return true;
    }
}