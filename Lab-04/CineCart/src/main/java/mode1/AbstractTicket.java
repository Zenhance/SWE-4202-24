package model;

public abstract class Abstractticket extends lineitem{
    protected Showtime showtime;
    protected int row;
    protected int seat;
    protected double base;

    public Abstractticket (Showtime showtime, int row, int seat){
        this.showtime=showtie;
        this.row=row;
        this.seat=seat;
        this.base=showtime.getmovie().getBasePrice;
    }
    protected double peakMultiplier(){
        if(showtime.isPeak()) return 1.20;
        return 1.00;
    }
}