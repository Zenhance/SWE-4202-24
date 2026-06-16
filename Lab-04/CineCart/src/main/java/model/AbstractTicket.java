package model;

public abstract class AbstractTicket extends LineItem {
    protected Showtime showtime;
    protected int row;
    protected int col;
    protected final double basePrice;

    public AbstractTicket(Showtime showtime ,int row,int col){
        this.showtime=showtime;
        this.row=row;
        this.col=col;
        this.basePrice=showtime.getMovie().getBasePrice();
    }
    protected double getPeakMultiplier(){
        return showtime.isPeak()?1.20:1.00;
    }
    @Override
    public boolean isTicket(){
        return true;
    }
    @Override
    public String describe(){
        return "T"+showtime.getId()+" R"+row+"C"+col;
    }

}
