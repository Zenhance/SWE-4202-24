package model;

public class Seat {


  private int row;
    private int col;
    boolean isPremium;
    boolean isBooked;

    public Seat(int row, int col, boolean isPremium) {
        this.row = row;
        this.col = col;
        this.isPremium = isPremium;
        this.isBooked = false;


    }
    public int getRow() {
            return row;
    }
    public int getCol() {
        return col;
    }
    public boolean getPremium() {
        return isPremium;
    }
    public boolean getBooked() {
        return isBooked;
    }












}