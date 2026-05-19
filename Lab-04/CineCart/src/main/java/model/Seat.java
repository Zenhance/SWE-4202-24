package model;

public class Seat {
    private int row;
    private int col;
    private boolean isPremium;
    private boolean isBooked;

    public Seat (int row,int col,boolean isPremium){

        this.row = row;
        this.col = col;
        this.isPremium = isPremium;
        this.isBooked = false;
    }

}
