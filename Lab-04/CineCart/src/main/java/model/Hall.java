package model;
public class Hall {
    private int id ,rows ,cols;
    private Seat[][] grid;


    public Hall(int id, int rows, int cols, int premiumRows){
        this.id=id;
        this.rows=rows;
        this.cols=cols;
    }

    public int getId() {
        return id;
    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }

    public Seat getSeat(int rows, int cols) {
        return grid[rows][cols];
    }


}
