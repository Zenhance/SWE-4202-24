package model;

public class StudentTicket extends LineItem {
    public StudentTicket(Showtime showtime, int i, int i1) {
        super();
    }
    public  double subtotal(){
        if (showtime.isPeak()){
            return pricePaid*1.2;}
        else{
            return pricePaid;}
    }
}
