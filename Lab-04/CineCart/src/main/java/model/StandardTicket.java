package model;

public class StandardTicket extends Ticket{
    public StandardTicket(Showtime showtime,int row,int col,double basePrice){
        super(showtime,row,col,basePrice);
    }

    public double subtotal(){
        return basePrice = peak();
    }

    public String describe(){
        return "Standard Ticket R" + row + "C" + col;
    }
}
