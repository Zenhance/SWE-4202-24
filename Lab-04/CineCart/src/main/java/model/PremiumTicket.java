package model;

public class PremiumTicket extends AbstractTicket {
    public PremiumTicket(Showtime showtime, int i, int i1) {
        super(showtime,i,i1);
    }

    public double subtotal() {if (showtime.isPeak()){
        return pricePaid*1.2;}
    else{
        return pricePaid;}
    }

    public String describe() {
        return null;
    }
}
