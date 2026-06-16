package model;

public class StudentTicket extends AbstractTicket
{
    protected static final double STUDENT = 0.50;

    public StudentTicket(Showtime showtime, int row, int col)
    {
        super(showtime, row, col);
    }

    @Override
    public double subtotal()
    {
        return base*STUDENT*peakTime();
    }

}