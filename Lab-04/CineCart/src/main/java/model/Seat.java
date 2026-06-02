package model;

public class Seat {
    int row;
    int col;
    boolean isPremium;
    boolean isBooked;

    public Seat(int row, int col, boolean isPremium, boolean isBooked)
    {
        this.row=row;
        this.col=col;
        this.isPremium=isPremium;

    }
    public int getRow(){
        return this.row;
    }
    public int getCol(){
        return this.col;
    }
    public boolean getIsPremium(){
        return this.isPremium;
    }
    public boolean getIsBooked(){

    }


}
