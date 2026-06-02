package model;
public class Hall {
    private int id ,rows ,cols;
    private Seat[][] grid;


    public Hall(int id, int rows, int cols, int premiumRows){
        this.id=id;
        this.rows=rows;
        this.cols=cols;
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

    public Seat getSeat(int rows, int cols) {
        return grid[rows][cols];
    }

    public int countAvailable(){
        int count=0;
        for(int i =1;i<=rows;i++){
            for(int j=1;j<=cols;j++){
                if(grid[i][j].isAvailable())
                    count++;
            }

        }
        return count;

    }

    void displayLayout(){

        if(grid[rows][cols].isAvailable())
            String.format(".");
        else
        if(grid[rows][cols].isPremium())
            String.format("*");
        else
            String.format("#");

    }


}
