package model;

public class StandardTicket extends AbstractTicket{
    public StandardTicket(Showtime showtime, int row, int col){
        super(showtime, col, row);
    }
    public double subtotal(){
        return baseprice*peak();
    }
    public String describe(){
        return ("Total price:" + baseprice*peak());

    }
}
