package model;

public class Seat{
    private int row;
    private int col;
    private boolean isPremium;
    private boolean isBooked;

    public Seat(int row, int col, boolean isPremium){
        this.row = row;
        this.col = col;
        this.isPremium = isPremium;
        this.isBooked = false;
    }

    public int getRow(){
        return row;
    }

    public int getCol(){
        return col;
    }


    public boolean isPremium(){
        return isPremium;
    }

    public void release(){
        isBooked = false;
    }

    public boolean isBooked() {
        return isBooked;
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

    public String toString(){
        if(isPremium){
            return String.format("R%dC%d*", row, col);
        }
        if(isBooked){
            return String.format("R%dC%d#", row, col);
        }

        return String.format("R%dC%d", row, col);
    }

}