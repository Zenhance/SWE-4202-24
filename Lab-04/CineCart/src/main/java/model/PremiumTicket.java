package model;

public  class PremiumTicket extends AbstractTicket {
    public PremiumTicket(Showtime showtime,int col,int row){
        super(showtime,col,row);
    }
    public String describe(){
        return "Premium Ticket";
    }
    public double subtotal(){
        return (basePrice*1.3)*getPeakMultiplier();
    }
}
