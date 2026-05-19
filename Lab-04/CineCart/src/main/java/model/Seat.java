package model;

public class Seat
{
    private int row;
    private int col;
    private boolean isPremium;
    private boolean isBooked;

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

    public int getCol()
    {
        return col;
    }

    public boolean isPremium()
    {
        return isPremium;
    }

    public boolean isBooked()
    {
        return isBooked;
    }


}
