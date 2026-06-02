package model;

public class Hall {
    int id;
    int rows;
    int cols;
    Seat [][] grid;
    Hall(int id, int rows, int cols, int premiumRows){
        this.id=id;
        this.rows=rows;
        this.cols=cols;
        this.grid= new Seat[rows][cols];
        for(int r=0;r<rows;r++){
            for(int c=0;r<cols;c++){
               boolean isPremium = (r < premiumRows);
               grid[r][c]=new Seat(r,c,isPremium);
            }
        }
    }
    int getId(){
        return id;
    }
    int getCols(){
        return cols;
    }
    Seat[][] getGrid(){
        return grid;
    }
    public Seat getSeat(int rows,int cols){
        return grid[rows][cols];
    }
    int countAvailable(){
        int count=0;
        for(int r=0;r<rows;r++){
            for(int c=0;r<cols;c++){
                if(grid[r][c].isAvailable()){
                    count++;
                }
            }
        }
        return count;
    }
    void displayLayout(){
        for(int r=0;r<rows;r++){
            for(int c=0;r<cols;c++){
                System.out.printf(grid[r][c].toString()+" ");
            }
            System.out.printf("\n");
        }
    }
}
