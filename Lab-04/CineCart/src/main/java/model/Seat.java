package model;

public class Seat {
    private int row;
    private int col;
    private boolean isPremium;
    private boolean isBooked;

    public Seat(int row, int col, boolean isPremium, boolean isBooked){
        this.row = row;
        this.col = col;
        this.isPremium = isPremium;
        this.isBooked = isBooked;
    }

    public int getRow(){
        return row;
    }

    public int getCol(){
        return col;
    }

    public boolean getIsPremium() {
        return  isPremium;
    }

    public boolean getIsBooked(){
        return isBooked;
    }

    public void book(){
        isBooked = true;
    }

    public void release(){
        isBooked = false;
    }

    public boolean isAvailable(){
        if (isBooked) return false;
        return true;

    }

    public String toString(){
        String string = String.format("R%dC%d",row,col);
        if (isPremium) string = string + "*";
        if (isBooked) string = string + "#";
        return string;
    }

}

