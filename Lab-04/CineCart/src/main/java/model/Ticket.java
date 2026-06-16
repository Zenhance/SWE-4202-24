package model;

public abstract class Ticket extends LineItem
{
    protected Showtime showtime;
    protected int row;
    protected int col;
    protected double base;

    public Ticket(Showtime showtime, int row, int col)
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

}