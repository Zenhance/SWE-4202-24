package model;

public abstract class AbstractTicket extends LineItem{
    protected double base;
    protected int row;
    protected int col;
    protected Showtime showtime;

    public AbstractTicket(Showtime showtime,int row,int col){
        this.showtime=showtime;
        this.row=row;
        this.col=col;
        this.base=showtime.getMovie().getBasePrice();
    }
    protected double peakMultiplier(){
        if(showtime.isPeak()){
            return 1.20;
        }
        return 1.00;
    }

    public boolean isTicket(){
        return true;
    }

    public String describe(){
        return "T"+showtime.getId()+" - R"+row+"C"+col;
    }
}
