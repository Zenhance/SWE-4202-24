package model;

public class Hall {
    private final int id;
    private final int rows;
    private final int cols;
    private final Seat[][] grid;

    public Hall(int id, int rows, int cols, int premiumRows) {
        this.id = id;
        this.rows = rows;
        this.cols = cols;
        this.grid = new Seat[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                grid[r][c] = new Seat(r, c, r< premiumRows);

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

    public Seat getSeat(int row, int col) {
        return grid[row][col];
    }

    public int countAvailable() {
        int count = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c].isAvailable()) count++;
            }
        }
        return count;
    }
    public void displayLayout() {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                Seat s = grid[r][c];
                if (!s.isAvailable())   System.out.print('#');
                else if (s.isPremium()) System.out.print('*');
                else                    System.out.print('.');
            }
            System.out.println();
        }
    }




}