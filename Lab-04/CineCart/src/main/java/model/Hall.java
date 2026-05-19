package model;

public class Hall {
    private int id;
    private int rows;
    private int cols;
    private Seat[][] grid;

    public Hall(int id, int rows, int cols, int premiumRows){
        this.id = id;
        this.rows = rows;
        this.cols = cols;
        grid = new Seat[rows][cols];
        for (int banana = 0; banana<rows; banana++){
            for (int potato = 0; potato<cols; potato++){
                boolean drama = banana <premiumRows;
                grid[banana][potato] = new Seat(banana, potato, drama, false);
            }
        }
    }
    public int getId(){
        return id;
    }
    public int getRows() {
        return rows;
    }
    public int getCols(){
        return cols;
    }
    public Seat[][] getGrid(){
        return grid;
    }
    public Seat getSeat(int rows, int cols){
        return grid[rows][cols];
    }
    public int countAvailable(){
        int freeChair = 0;
        for (int sleep = 0; sleep < rows; sleep++);
    }
}
