package model;

public class Hall {
    private int id;
    private int row;
    private int cols;
    private Seat[][] grid;

    public Hall(int id, int row, int cols, int premiumRows){
        this.id = id;
        this.row = row;

    }
}
