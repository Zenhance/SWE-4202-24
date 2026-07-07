package model;

public abstract class AbstractTicket {
    protected Showtime showtime;
    protected int row;
    protected int col;
    protected double baseprice;
    public AbstractTicket(Showtime showtime, int row, int col){
        this.showtime = showtime;
        this.col = col;
        this.row = row;
    }
    public double peak(){
        if(showtime.isPeak()){
            return baseprice*1.2;
        }
        else {
            return baseprice*1;
        }
    }
}
