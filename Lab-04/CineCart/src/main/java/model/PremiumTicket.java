package model;

public class PremiumTicket extends Ticket{

    public static final double PremiumFactor=1.30;

    public PremiumTicket(Showtime showtime,int row,int col){
        super(showtime,row,col);
    }
public double subtotal(){
        return pricePaid*PremiumFactor*peakFactor;
}

}
