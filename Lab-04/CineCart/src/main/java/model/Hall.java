package model;

public class Hall {
    private int id;
    private int rows;
    private int cols;
    private Seat[][] grid;

    public Hall(int id, int rows, int cols, int premiumRows){
        this.rows =rows;
        this.cols= cols;
        this.grid= new Seat[rows][cols];

        for(int r=0; r<rows; r++){
            boolean isPremium=( r< premiumRows);
            for(int c=0; c<cols; c++)
            {
                grid[r][c] = new Seat(r, c, premium);
            }

        }
    }

    public int getId() {
        return id;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public Seat[][] getSeat(int rows, int cols) {
        return grid[rows][cols];
    }
}
