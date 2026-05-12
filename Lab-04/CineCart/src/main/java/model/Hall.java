package model;

public class Hall {
    int id, rows, cols;
    Seat[][] grid;
    Hall(int id, int rows, int cols, int premiumRows){
        this.id=id;
        this.rows=rows;
        this.cols=cols;
       // this.grid=new Seat[rows][cols];
        for(int r=0;r<rows;r++)
        {
            boolean isPremium=(r<premiumRows);
            for (int c=0;c<cols;c++)
            {
                grid[r][c] = new Seat(r, c, isPremium);
            }
        }
    }
    public int countAvailable(){
        int count=0;
        for(int r=0;r<rows;r++){
            for (int c=0;c<cols;c++)
            {
                if(grid[r][c].isAvilable()) count++;
            }
        }
        return count;
    }
    public void displayLayout(){
        for(int r=0;r<rows;r++){
            for (int c=0;c<cols;c++)
            {
                if(grid[r][c].isAvilable()) System.out.print(".");
                else if (!grid[r][c].isAvilable()) System.out.print("#");
                else if (grid[r][c].isAvilable()&&grid[r][c].isPremium) System.out.print("*");
            }
            System.out.println();
        }
    }
    public Seat getSeat(int row, int col){
        return grid[row][col];
    }

}
