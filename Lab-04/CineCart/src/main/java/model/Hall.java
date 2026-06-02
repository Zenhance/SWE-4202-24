package model;

public class Hall {
    int id;
    int rows;
    int cols;
    Seat[][] grid;
    public Hall(int id,int rows,int cols,int premiumRows){
        this.id=id;
        this.rows=rows;
        this.cols=cols;
        this.grid = new Seat[rows][cols];

        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                boolean isPremium = r<premiumRows;
                grid[r][c]=new Seat(r,c,isPremium);
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
    public Seat[][] getGrid(){
        return grid;
    }

    public Seat getSeat(int rows, int cols){
        return grid[rows][cols];

    }
    int count=0;
    public int countAvailable(){
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j].isAvailable()) {
                    count++;
                }
            }
        }return count;
    }
     void displayLayout(){
        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(grid[r][c].isAvailable()){
                    System.out.println(".");
                }
                else if(grid[r][c].isBooked()){
                    System.out.println("#");
                }
                else if(grid[r][c].isPremium()){
                    System.out.println("*");
                }
            }
        }
    }
}
