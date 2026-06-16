package model;

public class PremiumTicket extends AbstractTicket{
    public PremiumTicket (Showtime showtime, int row, int col){
        super(showtime, col, row);
    }
    public double subtotal(){
        return baseprice*1.3*peak();
    }
    public String describe(){
        return ("Total price:" + baseprice*1.3*peak());

    }
}
