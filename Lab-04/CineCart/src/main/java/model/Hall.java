package model;

public class Hall {
    private int id;
    private int rows;
    private int cols;
    private Seat[][] grid;

    public Hall(int id, int rows, int cols, int premiumRows) {
        Seat[][] grid = new Seat[rows][cols];
        this.id = id;
        this.rows = rows;
        this.cols = cols;

        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                if(r < premiumRows) grid[r][c] = new Seat(r,c, true);
                else grid[r][c] = new Seat(r,c,false);
            }
        }

        this.grid = grid;

    }

    public Seat getSeat(int row, int col) {
        return this.grid[row][col];
    }

    public int countAvailable() {
        int count = 0;
        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                if(grid[r][c].isAvailable()) {
                    count++;
                }
            }
        }
        return count;
    }

    public void displayLayout() {
        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                if(grid[r][c].isAvailable()) System.out.println(".");
                if(grid[r][c].isBooked()) System.out.println("#");
                if(grid[r][c].isPremium() && grid[r][c].isAvailable()) System.out.println("*");


            }
        }
    }


    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public int getId() {
        return id;
    }
}
