package model;

public class Seat
{
    int row;
    int col;
    boolean isPremium;
    boolean isBooked;

    public Seat(int row, int col, boolean isPremium, boolean isBooked)
    {
        this.row = row;
        this.col = col;
        this.isPremium = isPremium;
        this.isBooked = isBooked;
    }

    public int getRow()
    {
        return row;
    }

    public boolean isPremium()
    {
        return isPremium;
    }

}
