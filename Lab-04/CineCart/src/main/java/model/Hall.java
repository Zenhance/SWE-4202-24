package model;

public class Hall {
    private int id;
    private int rows;
    private int cols;
    private Seat[][] grid;

    public Hall(int id, int rows, int cols, int premiumRows) {
        this.id = id;
        this.rows = rows;
        this.cols = cols;
        this.grid = new Seat[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                boolean premium;
                if (r < premiumRows) {
                    premium = true;
                } else {
                    premium = false;
                }
                grid[r][c] = new Seat(r, c, premium);
            }
        }
    }

    public int getId() {
        return id;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }
}