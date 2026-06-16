package model;

public class PremiumTicket extends AbstractTicket{
    public PremiumTicket(Showtime showtime,int row,int col){
        super(showtime,row,col);
    }
    public double subtotal(){
        return basePrice*1.20*peak();
    }
    public String describe(){
        return "Premium Ticket";
    }

}
