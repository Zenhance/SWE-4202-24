package model;

public abstract class Ticket extends LineItem{
    protected Showtime showtime;
    protected int row;
    protected int col;
    protected double pricePaid;
    public Ticket(Showtime showtime,int row,int col,double pricePaid){
        this.showtime=showtime;
        this.row=row;
        this.col=col;
        this.pricePaid=pricePaid;
    }
    protected double peakMultiplier(){
        return showtime.isPeak() ? 1.20:1.00;
    }
    public boolean isTicket(){
        return true;
    }
    public String describe(){
        return "Seat("+row+","+col+")";
    }
    public Showtime getShowtime(){
        return showtime;
    }
    public int getRow(){
        return row;
    }
    public int getCol(){
        return col;
    }
    public double getPricePaid(){
        return pricePaid;
    }
    public String toString(){
        return "T"+showtime.getId()+" - R"+row+"C"+col+" @ BDT"+String.format("%.2f",pricePaid);
    }
}
