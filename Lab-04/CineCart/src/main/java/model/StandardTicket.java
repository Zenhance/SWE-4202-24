package model;

public class StandardTicket extends AbstractTicket{
    public StandardTicket(Showtime showtime, int row, int col){
        super(showtime,row,col);
    }

    public double subtotal(){
        double basePrice;
        return this.basePrice * peak();
    }
    public String describe(){
        return "standard Ticket.";
    }
}
