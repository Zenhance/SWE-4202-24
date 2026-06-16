package model;

public class StudentTicket extends Ticket
{
    protected static final double STUDENT = 0.50;

    public StudentTicket(Showtime showtime, int row, int col)
    {
        super(showtime, row, col);
    }

    @Override
    public double subTotal()
    {
        return base*STUDENT*peakTime();
    }

}