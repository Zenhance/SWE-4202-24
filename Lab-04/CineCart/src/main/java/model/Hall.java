package model;

public class Hall {
    public int id;
    public int rows;
    public int cols;
    public Seat[][] grid;

    public Hall(int id, int rows, int cols, int premiumRows){
        this.id=id;
        this.rows=rows;
        this.cols=cols;
        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                boolean Premium;
                if(r<premiumRows){
                    Premium=true;
                }else{
                    Premium=false;
                }
                grid[r][c] = new Seat(r, c, Premium);
            }
        }
    }
}
