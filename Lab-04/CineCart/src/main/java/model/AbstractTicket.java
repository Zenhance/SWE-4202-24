package model;

public abstract class AbstractTicket extends LineItem {
    public Showtime showtime;
    public int i, i1;

    public AbstractTicket(Showtime showtime, int i, int i1){
        this.showtime = showtime;
        this.i = i;
        this.i1 = i1;
    }
}
