package model;
public class Hall
{
    private int id;
    private int rows;
    private int cols;
    private Seat[][] grid;

    public Hall(int id, int rows, int cols, Seat grid)
    {
        this.id=id;
        this.rows=rows;
        this.cols=cols;

    }


}
