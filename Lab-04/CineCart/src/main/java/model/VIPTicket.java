package model;

public class VIPTicket extends AbstractTicket {
    public VIPTicket(Showtime st, int i, int i1) {
        super();
    }
    public double subtotal(){
            if (showtime.isPeak()){
                return pricePaid*1.2;}
            else{
                return pricePaid;}
        }
    }
}
