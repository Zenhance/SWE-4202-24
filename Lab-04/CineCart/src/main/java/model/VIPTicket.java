package model;

public class VIPTicket extends AbstractTicket{
    public VIPTicket(Showtime showtime, int row, int col){
        super(showtime, col, row);
    }
    public double subtotal(){
        return baseprice*1.3*peak() + 200;
    }
    public String describe(){
        return ("Total price:" + baseprice*1.3*peak() + 200);

    }
}
