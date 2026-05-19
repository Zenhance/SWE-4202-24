package model;

public class Hall {
    private int id;
    private int rows;
    private int cols;
    private Seat[][] grid;

    public Hall(int id, int rows,int cols,int premiumRows){
        this.id=rows;
        this.cols=cols;
        this.grid=new Seat[rows][cols];

        for(int r=0;r<rows;r++){
            boolean isPremium=(r<premiumRows);
            for(int c=0;c<cols ) {

                grid[r][c]= new Seat(r,c,premium);
            }
        }
    }
    public int getID(){
        return id;
    }
    public int getRow(){
        return row;}
    public int getCol(){
        return col;}

}