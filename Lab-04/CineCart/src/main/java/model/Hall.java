package model;

public class Hall {
    private int id;
    private int rows;
    private int cols;
    private Seat[][] grid;
    public Hall(int id, int rows, int cols, int premiumRows){
        this.id = id;
        this.rows= rows;
        this.cols= cols;
        this.grid = new Seat[rows][cols];
        for (int r=0; r<rows; r++){
            for(int c=0; c<cols; c++){
                grid[r][c] = new Seat(r, c, r<premiumRows);
            }
        }
    }
    public Seat getSeat(int row, int col){
        return grid[row][col];
    }
    public int countAvailable(){
        int count = 0;

        for(int r=0; r<rows; r++){
            for (int c = 0; c< cols; c++){
                if (getSeat( r,c).isAvailable()){
                    count++ ;
                }
            }

        }

        return count;
    }
}

public void displayLayout(){
    for (int r= 0; r< rows; r++){
        for (int c = 0; c<cols; c++){
            if (!grid[r][c].isavailable()){
                System.out.print("*");
            }
            else {
                System.out.print(".");
            }
        }
        System.out.println();
    }
}


