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

    }

    public Seat getSeat(int row, int col){
        return grid[row][col];
    }

    public int countAvailable(){
        int cnt = 0;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j].isAvailable()){
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public void displayLayout(){
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j].isAvailable()){
                    System.out.print(".");
                }
                else if(grid[i][j].isBooked()){
                    System.out.print("#");
                }
                else if(grid[i][j].isPremium()){
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
}
