package model;

public class Hall {
    private int id;
    private int rows;
    private int cols;
    private Seat[][] grid;

    Hall(int id, int rows, int cols, int premiumRows){
        this.id = id;
        this.rows = rows+premiumRows;
        this.cols = cols;
        grid = new Seat[this.rows][this.cols];
    }

    public Seat getSeat(int row, int col){
        return grid[row][col];
    }

    int countAvailable(){
        int availCount = 0;
        for(int i = 0; i < rows)
    }

    void displayLayout(){
        for()
    }
}
