package model;

public class Seat {
    private final int row;
    private final int col;
    private final boolean isPremium;
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
        return  col;
    }
    public boolean isPremium() {
        return isPremium;
    }
    public boolean isBooked() {
        return isBooked;
    }

    public boolean book(){
        if(isBooked){
            return false;
        }
        else{
            isBooked = true;
            return true;
        }
    }
    public void release(){
        this.isBooked = false;
    }
    public boolean isAvailable(){
        return !isBooked;
    }

    //"R3C5" with a trailing * if premium, # if booked.
    public String toString(){
        String s = String.format("R%dC%d",getRow(),getCol());
        if(isPremium) s = s+'*';
        if(isBooked) s = s+'#';
        return s;
    }
}
