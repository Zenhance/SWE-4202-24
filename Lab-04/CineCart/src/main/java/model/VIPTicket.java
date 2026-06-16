package model;

public class VIPTicket extends PremiumTicket{
    public VIPTicket(Showtime showtime,int row,int col,double basePrice){
        super(showtime,row,col,basePrice);
    }

    public double subtotal(){
        return super.subtotal() + 200.0;
    }

    public String describe(){
        return super.describe() + " + Lounge";
    }
}
