package model;

public abstract class Ticket extends LineItem{
    protected final Showtime showtime;
    protected final int row;
    protected final int col;
    protected double basePrice;

    public Ticket(Showtime showtime,int row,int col,double basePrice){
        this.showtime=showtime;
        this.row=row;
        this.col=col;
        this.basePrice=showtime.getMovie().getBasePrice();
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
        return "Ticket R" + row + "C" + col;
    }
}
