package model;

public class Hall {
    // Fields: int id, int rows, int cols, Seat[][] grid.
    // Constructor: Hall(int id, int rows, int cols, int premiumRows) — builds the grid; for each
    // row index r and column index c, create a Seat with isPremium = (r < premiumRows).

    public int id;
    public int rows;
    public int cols;
    public Seat[][] grid;

    public Hall(int id, int rows, int cols, int premiumRows) {
        this.id = id;
        this.rows = rows;
        this.cols = cols;
        this.grid = new Seat[rows][cols];

        for (int r=0; r<rows; r++) {
            for (int c = 0; c <cols; c++) {
                boolean isPremium = (r< premiumRows);
                grid[r][c] = new Seat(r, c, isPremium);

                }
            }
        }

        Seat getSeat(int row, int col) {
            return grid[row][col];
        }
    }
