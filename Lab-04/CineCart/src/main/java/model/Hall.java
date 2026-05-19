package model;

public class Hall {
    private int id;
    private int rows;
    private int cols;
    private Seat [][] grid;

public Hall(int id, int rows, int cols, int premiumRows){
    this.id = id;
    this.rows = rows;
    this.cols = cols;
    boolean premium;
    for (int r = 0; r < rows; r++){
        for (int c = 0; c < cols; c++){
            if(r < premiumRows){
                premium = true;
            }
            else {
                premium = false;
            }

            grid[r][c] = new Seat(r, c, premium);
        }
    }
}
}
