package model;
//Part A.3
public class Hall {
    private final int id;
    private final int rows;
    private final int cols;
    private final Seat[][] grid;

    public Hall(int id, int rows, int cols, int premiumRows){
        this.id = id;
        this.rows = rows;
        this.cols = cols;

        grid = new Seat[rows][cols];
        int r = 0;
        while(r<rows){
            for(int c=0;c<cols;c++){
                boolean isPremium = (r<premiumRows);

                grid[r][c] = new Seat(r,c,isPremium);
            }
            r++;
        }
    }

    public int getId() {
        return id;
    }
    public int getRows(){
        return rows;
    }
    public int getCols() {
        return cols;
    }

    public Seat getSeat(int row, int col){
        return grid[row][col];
    }

    public int countAvailable(){
        int count = 0;
        for(int i=0;i<getRows();i++){
            for(int j=0;j<getCols();j++){
                if(grid[i][j].isAvailable()) count++;
            }
        }
        return count;
    }

    public void displayLayout(){
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j].isBooked()) System.out.print("#");
                else if(grid[i][j].isPremium()) System.out.print("*");
                else if(grid[i][j].isAvailable()) System.out.print(".");
                if(j==cols-1) System.out.println();
            }
        }
    }
}
