package model;

public abstract class AbstractTicket extends LineItem {
    protected double peak = 1.20;
    protected Showtime showtime;
    protected int row;
    protected int col;
    protected double base;


    public AbstractTicket(Showtime showtime, int row, int col){
        this.showtime = showtime;
        this.col = col;
        this.row = row;
        base = showtime.getMovie().getBasePrice();
    }

    public Showtime getShowtime() {
        return showtime;
    }





    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public String toString(){
        return String.format("T%d - R%dC%d @ BDT %.2f",showtime.getId(), row, col);
    }
}
