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
        grid = new Seat[rows][cols];

        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                boolean isPremium = (r<premiumRows);
                grid[r][c] = new Seat(r,c,isPremium);
            }
        }
    }
    Seat getSeat(int row,int col){
        return Seat[row][col];
    }
    int countAvailable(){
        int count=0;
        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(grid[r][c].isAvailable()){
                    count++;}
            }
        }
        return count;
    }
    void displayLayout(){

    }
}
