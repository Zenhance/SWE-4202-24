package model;

public class VIPTicket extends LineItem {
    public VIPTicket(Showtime st, int i, int i1) {
        super(st,i, i1);
    }
    public double subtotal(){
            if (showtime.isPeak()){
                return pricePaid*1.2;}
            else{
                return pricePaid;}
        }}


