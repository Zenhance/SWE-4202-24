package model

public abstract class Ticket extends LineItem
{
    protected Showtime showtime;
    protected int row;
    protected int col;
    protected double basePrice;

    protected Ticket(Showtime showtime, int row, int col, double basePrice)
    {
        this.showtime = showtime;
        this.row = row;
        this.col = col;
        this.basePrice = showtime.getMovie().getBasePrice();
    }

}