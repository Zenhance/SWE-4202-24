package model;

public class Hall {

    //fields
    private int id;
    private int rows;
    private int cols;
    private int Seat[][] grid;


    //constructors
    public Hall(int id, int rows, int cols, int premiumRows) {

        this.id = id;
        this.rows = rows;
        this.cols = cols;
        this.grid = new Seat [rows][cols];

        for (int r = 0; r < rows; r++)
        {
            boolean isPremium = (r < premiumRows);

            for (int c = 0; c < cols; c++) {
                grid [r][c] = new Seat(r, c, isPremium);

            }
        }



    }

    //methods
    public Seat getSeat(int row, int col) {

    }

    public int countAvailable() {

    }

    public void displayLayout() {

    }
}