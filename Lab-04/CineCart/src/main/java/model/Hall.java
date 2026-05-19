package model;

public class Hall {
private int id;
private int rows;
private int cols;
private Seat [][] grid;


public Hall (int id, int rows, int cols, int premiumRows)
{
 this.id=id;
 this.rows=rows;
 this.cols = cols;

 for (int r=0; r<rows; r++)
    {
for (int c=0; c<cols; c++)
{
    if (r<premiumRows) grid [r] [c] = new Seat ( r, c , true);
}    }
}

public Seat getSeat  (int row, int col)
{
    return grid [row] [col];
}
public int countAvailable() {
    int count = 0;
    for (int r = 0; r < rows; r++) {
        for (int c = 0; c < cols; c++) {
            if (grid[r][c].isAvailable()) System.out.println(".");
            if (grid[r][c].getIsBooked()) System.out.println("#");
            if (grid[r][c].getIsPremium() && grid[r][c].isAvailable()) System.out.println("*");


        }


    }

}
}