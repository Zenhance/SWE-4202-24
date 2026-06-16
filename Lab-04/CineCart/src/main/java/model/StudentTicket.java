package model;

public class StudentTicket extends AbstractTicket{
    public StudentTicket(Showtime showtime, int row, int col){
        super(showtime, row, col);
    }

    @Override
    public double subtotal(){
        if (getShowtime().isPeak())
            return 350.00 * 0.50 * 1.20;
        else return 200.00 * 0.50;
    }

    @Override
    public String describe() {
        String string = String.format("subtotal : %f BDT", subtotal());
        return string;
    }
}
