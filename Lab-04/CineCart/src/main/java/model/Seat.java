package model;

public class Seat {
    private int row;
    private int col;
    private boolean isPremium;
    private boolean isBooked;

    public Seat(int row, int col, boolean isPremium){
        this.row = row;
        this.col = col;
        this.isPremium = isPremium;
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
    public boolean isBooked(){
        return isBooked;
    }

    public boolean book(){
        isBooked = true;
        return false;
    }

    public void release(){
        isBooked = false;
    }

    public boolean isAvailable(){
    if(isBooked == true)
        return false;
    else
        return true;
    }

    public String toString(){
        String ans = String.format("R%dC%d", row, col);
        if(isPremium)
            ans += "*";
        if(isBooked)
            ans += "#";
        return ans;
    }
}
