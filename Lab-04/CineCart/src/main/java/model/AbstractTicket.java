package model;

public abstract class AbstractTicket extends LineItem
{
    protected Showtime showtime;
    protected int row;
    protected int col;
    protected double base;

    public AbstractTicket(Showtime showtime, int row, int col)
    {
        this.showtime = showtime;
        this.row = row;
        this.col = col;
        this.base = showtime.getMovie().getBasePrice();
    }

    public Showtime getShowtime()
    {
        return showtime;
    }

    public int getRow()
    {
        return row;
    }

    public int getCol()
    {
        return col;
    }

    public double getPricePaid()
    {
        return base;
    }

    public double peakTime()
    {
        if(showtime.isPeak())
        return base*1.20;
        else
        return base;
    }

    @Override
    public String describe()
    {
        return showtime.getMovie().getTitle()+" R"+row+"C"+col;
    }
}