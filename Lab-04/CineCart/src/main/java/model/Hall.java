package model;

public class Hall {
    public int id;
    public int rows;
    public int cols;
    public Seat[][]grid;
    //constructor
    public Hall(int id, int rows, int cols, int premiumRows){
        this.id=id;
        this.rows=rows;
        this.cols=cols;
    }




}
