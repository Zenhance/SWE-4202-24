package model;

public class StandardTicket extends AbstractTicket{
    public StandardTicket(Showtime showtime, int row, int col){
        super(showtime,row,col);
    }
    @Override
    public double subTotal(){
        return base*peakMultiplier();
    }
    @Override
    public String describe(){
        return super.describe()+" Standard";
    }
}
