package model;

public class Seat {
    private int row;
    private int col;
    private boolean isPremium;
    private boolean isBooked;

    Seat(int row, int col, boolean isPremium, boolean isBooked){
        this.row = row;
        this.col = col;
        this.isPremium = isPremium;
        this.isBooked = isBooked;
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
    void book(){
        isBooked = true;
    }
    void release(){
        isBooked = false;
    }
    boolean isAvailabe(){
        if(isBooked = true){return false;}
        else return true;
    }
    public String toString(){

    }

}
