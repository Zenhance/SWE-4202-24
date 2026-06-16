package model;

public class PremiumTicket extends AbstractTicket {
public PremiumTicket(Showtime showtime,int col,int row){
    super(showtime,col,row);
}
@Override
public double subtotal(){
    return basePrice*1.30*peak();
}
@Override
    public String describe(){
    return "Premium Ticket";
}
}
