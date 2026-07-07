package model;

public abstract class AbstractTicket extends LineItem{
    private Showtime showtime;
    private int row;
    private int col;
    private double base;

    public AbstractTicket(Showtime showtime, int row, int col) {
        this.showtime=showtime;
        this.row=row;
        this.col=col;
        this.base=base;
    }

    public double peakMultiplier(){
        return 0.0;
    }

    public String describe() {
        return null;
    }

    public boolean isTicket() {
        return false;
    }
}
