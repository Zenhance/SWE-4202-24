package model;

public class Hall {
    private int id;
    private int rows;
    private int cols;
    private Seat[][] grid;


    public int getId(){
        return this.id;
    }
    public int rows(){
        return this.rows;
    }
    public int cols(){
        return this.cols;
    }
    public Hall(int id, int rows, int cols, int premiumRows){
         grid = new Seat[rows][cols];
         for(int r =0; r<rows; r++){
             for(int c=0; c<cols; c++){
                 boolean isPremium = r<premiumRows;
             }
         }
    }
    Seat getSeat(int row, int col){
        return grid[row][col];
    }
    int countAvailable(){
        int count = 0;
        for(int r=0; r<rows; r++){
            for(int c = 0; c<cols; c++){
                if(grid[r][c].isAvailable()){
                    count++;
                }
            }
        }
        return count;
    }
    void displayLayout() {

    }

}
