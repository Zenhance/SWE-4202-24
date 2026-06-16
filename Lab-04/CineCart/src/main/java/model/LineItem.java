package model;

public class LineItem extends AbstractTicket{

    public LineItem(Showtime showtime, int row, int col) {
    }

    public LineItem() {

    }
    public double subtotal(){
        if (showtime.isPeak()){
            return pricePaid*1.2;}
        else{
            return pricePaid;}}
}
