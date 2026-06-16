package model;

public abstract class AbstractTicket extends LineItem{
    protected final Showtime showtime;
    protected final int row;
    protected final int col;
    protected final double base;
}
