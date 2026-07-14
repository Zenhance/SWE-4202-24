package model;

public class VIPTicket extends AbstractTicket{
    public VIPTicket(Showtime showtime,int row, int col){
        super(showtime,row,col);
    }

    public double subtotal(){
        double basePrice
        return (basePrice * 1.50 * peak())+200;
    }

    public String describe(){
        return "VIP Ticket";
    }
}
