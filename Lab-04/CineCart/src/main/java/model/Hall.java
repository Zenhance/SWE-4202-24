package model;

public class Hall {
    private int id;
    private int rows;
    private int cols;
    Seat[][] grid;

    Hall(int id,int rows,int cols, int premiumRows) {
        this.id=id;
        this.rows=rows;
        this.cols=cols;
        grid=new Seat[rows][cols];
    }

    public Seat getSeat(int row, int col) {
        return grid[row][col];
    }

    public int countAvailable() {

    }

    public void displayLayout() {

    }
}