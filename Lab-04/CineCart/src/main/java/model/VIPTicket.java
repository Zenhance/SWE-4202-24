package model;

public class VIPTicket extends AbstractTicket {
    public VIPTicket(Showtime showtime,int col,int row){
        super(showtime,col,row);
    }
    @Override
    public double subtotal(){
        return (basePrice*1.50*peak())+200.00;
    }
    @Override
    public String describe(){
        return "VIP Ticket";
    }
}
