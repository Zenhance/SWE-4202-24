package model;

public class PremiumTicket extends Ticket{

   public PremiumTicket(Showtime showtime,int row,int col){
       super(showtime,row,col);
   }
   @Override
    public double subtotal(){
       return base*1.30*peakMultiplier();
   }
   @Override
    public String describe(){
       return "Premium"+super.describe();
   }
}
