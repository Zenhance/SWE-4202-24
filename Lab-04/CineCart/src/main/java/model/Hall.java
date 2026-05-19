package model;

public class Hall {
    private int id;
    private int rows;
    private int cols;
    private Seat[][]grid;

    public Hall(int id,int rows,int cols,int premiumRows){
        this.id=id;
        this.rows=rows;
        this.cols=cols;
        this.grid=new Seat[rows][cols];

        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                grid[r][c] = new Seat(r,c,  r<premiumRows);
            }
        }
    }
    public Seat getSeat(){
        return grid[rows][cols];
    }

}

