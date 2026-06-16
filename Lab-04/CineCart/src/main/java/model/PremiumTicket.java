package model;

public class PremiumTicket extends Ticket{
    public PremiumTicket(Showtime showtime,int row,int col,double basePrice){
        super(showtime,row,col,basePrice);
    }

    public double subtotal(){
        return basePrice * 1.30 * peak();
    }

    public String describe(){
        return "Premium Ticket R" + row + "C" + col;
    }
}
