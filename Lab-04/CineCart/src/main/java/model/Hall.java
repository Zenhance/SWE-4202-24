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
        for (int r=0; r<rows; r++){
            for (int c=0; c<cols; c++){
                if (r<premiumRows)
                    this.grid[r][c] = new Seat(r,c,true);
                else this.grid[r][c] = new Seat(r,c,false);
            }
        }
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

    public Seat getSeat(int rows, int cols){
    return grid[rows][cols];
    }

    public int countAvailable(){
        int count = 0;
        for (int r=0; r<rows; r++){
            for (int c=0; c<cols; c++){
                if(grid[r][c].isAvailable())
                    count++;

            }
        }
    return count;
    }

    public void displayLayout(){
        for (int r=0; r<rows; r++){
            for (int c=0; c<cols; c++){
                if(grid[r][c].isAvailable())
                    System.out.println(".");
                if(grid[r][c].isBooked())
                    System.out.println("#");
                if(grid[r][c].isPremium())
                    System.out.println("*");
            }
        }
    }
}
