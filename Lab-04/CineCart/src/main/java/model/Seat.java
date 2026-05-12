package model;

public class Seat {
    private int row;
    private int col;
    private boolean isPremium;
    private boolean isBooked;

    public Seat(int row, int col, boolean isPremium, boolean isBooked){
        this.row = row;
        this.col = col;
        isPremium = false;
        isBooked = false;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public void book(){

    }

}
