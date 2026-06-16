package model;

import data.ShowtimeBoard;

public class StudentTicket extends Ticket{
    public StudentTicket(Showtime showtime,int row,int col){
        super(showtime,row,col);
    }
    @Override
    public double subtotal(){
        return super.subtotal() + 200.0;
    }
}
