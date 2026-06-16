package model;

import data.ShowtimeBoard;

public class StandardTicket extends Ticket{
    public StandardTicket(Showtime showtime,int row,int col){
        super(showtime,row,col);
    }
    @Override
    public double subtotal(){
        return basePrice*peakMultiplier();
    }
    @Override
    public String describe(){
        return "Standard " + super.describe();
    }
}
