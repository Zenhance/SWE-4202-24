package model;

public class StandardTicket extends AbstractTicket {
    public StandardTicket(Showtime base, int row, int col){
        super(base,row,col);
    }
    @Override
    public double subtotal(){
        return applyPeak(getBasePrice());
    }
    @Override
    public String describe(){
        return "Standard Ticket";
    }
}
