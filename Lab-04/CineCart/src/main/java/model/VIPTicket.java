package model;

public class VIPTicket extends AbstractTicket{
    public VIPTicket(Showtime showtime, int row, int col){
        super(showtime,row,col);
    }
    @Override
    public double subtotal(){
        return super.subtotal() + 200.00;
    }
    @Override
    public String describe(){
        return super.describe()+" + Lounge";
    }
}
