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
        return this.row;
    }
    public int getCol(){
        return this.col;
    }
    public boolean isPremium(){
        return this.isPremium;
    }
    public boolean isBooked(){
        return this.isBooked;
    }
    public void book(){
        isBooked = true;
    }
    public void release(){
        isBooked = false;
    }
    public boolean isAvailable(){
        if(isBooked==true){return false;}
        else return true;
    }
    public String toString(){
        return String.format("R%dC%d",row,col,isPremium? "*": "", isBooked? "#": "");
    }

}
