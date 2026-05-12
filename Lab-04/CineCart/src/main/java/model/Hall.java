package model;

public class Hall {
    private int id;
    private int rows;
    private int cols;
    private Seat[][] grid;

    Hall(int id, int rows, int cols,int premiumRows){
        this.id = id;
        this.rows = rows;
        this.cols = cols;
        grid=new Seat[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
            }
        }
    }
}
