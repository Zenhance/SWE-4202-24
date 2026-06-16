package model;

public class StandardTicket extends LineItem{
    public StandardTicket(Showtime showtime, int row, int col) {
    super(showtime,row,col);
}
public  double subtotal(){
        if (showtime.isPeak()){
            return pricePaid*1.2;}
        else{
            return pricePaid;}
        }
    }

