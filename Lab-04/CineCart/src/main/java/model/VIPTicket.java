package model;

public class VIPTicket extends PremiumTicket{
    public VIPTicket(Showtime showtime, int row, int col){
        super(showtime,row,col);
    }
    @Override
    public double subtotal(){
        return super.subtotal();
    }
    @Override
    public String describe(){
        return super.describe()+" + Lounge Access";
    }
}
