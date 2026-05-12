package model;

public class Seat {
    int row;
    int col;
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
    public boolean isPremium() {
        return isPremium;
    }
    public boolean isBooked() {
        return isBooked;
    }
    public void book() {
        isBooked = true;
    }
    public void release() {
        isBooked = false;
    }
}
