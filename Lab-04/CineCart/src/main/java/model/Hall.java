package model;

public class Hall {
    private int id;
    private int rows;
    private int cols;
    private Seat[][] grid;

    Hall(int id, int rows, int cols, int premiumRows){
        this.id = id;
        this.rows = rows;
        this.cols = cols;
        this.grid = Seat[rows][cols];
        for (int r = 0; r<rows; r++){
            for (int c = 0; c<cols; c++){
                grid[r][c] = Seat(r,c,r<premiumRows);
            }
        }
    }

    public int getId(){
        return id;
    }

    public int getRows(){
        return rows;
    }

    public int getCols(){
        return cols;
    }

    public Seat getSeat(int row, int col){
        return grid[row][col];
    }

    public int countAvailable(){
        int count = 0;
        for(int r = 0; r<rows ; r++){
            for (int c = 0; c<cols;c++){
                count ++;
            }
        }
    }

}

