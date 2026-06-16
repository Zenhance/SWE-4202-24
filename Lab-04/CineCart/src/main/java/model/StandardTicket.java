package model;

public class StandardTicket {
    public StandardTicket(Showtime showtime,int row,int col){
        super();
    }
    public double subtotal(){
        return basePrice*peakMultiplier();
    }
    public String describe(){
        return "Standard "+super.describe();
    }
}
