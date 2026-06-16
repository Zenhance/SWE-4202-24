package model;

public class VIPTicket extends AbstractTicket{
    VIPTicket(Showtime showtime,int row,int col){
        super(showtime,col,row);
    }
    public double subtotal(){
        return (basePrice*1.50*peak())+200.0;
    }
    public String describe(){
        return "VIP Ticket";
    }
}
