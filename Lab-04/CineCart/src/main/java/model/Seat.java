package model;

public class Seat{
    private int row;
    private int col;
    private boolean isPremium;
    private boolean isAvailable;

    public Seat(int row, int col, boolean isPremium){
        this.row = row;
        this.col = col;
        this.isPremium = isPremium;
        this.isAvailable = false;
    }

    public int getRow(){
        return row;
    }

    public int getCol(){
        return col;
    }

    public boolean isAvailable(){
        return isAvailable;
    }

    public boolean isPremium(){
        return isPremium;
    }

    public void release(){
        isBooked = false;
    }

    public boolean isAvailable(){
        if (isBooked == true){
            return false;
        }
        else {
            return true;
        }
    }

    public void book(){
        isBooked = true;
    }

}