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
}
