package model;

import data.ShowtimeBoard;

public class PremiumTicket extends Ticket{
    public PremiumTicket(Showtime showtime,int row,int col){
        super(showtime,row,col);
    }
    @Override
    public double subtotal(){
        return basePrice*1.30*peakMultiplier();
    }
}
