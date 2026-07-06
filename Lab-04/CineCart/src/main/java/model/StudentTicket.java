package model;

public class StudentTicket extends StandardTicket
{
    protected static final double STUDENT = 0.50;

    public StudentTicket(Showtime showtime, int row, int col)
    {
        super(showtime, row, col);
    }

    @Override
    public double subtotal()
    {
        return STUDENT*peakTime();
    }

    @Override
    public String describe()
    {
        return super.describe()+" Student";
    }
}