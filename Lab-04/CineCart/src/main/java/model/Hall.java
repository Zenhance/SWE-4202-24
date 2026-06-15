package model;

public class Hall {
    int id;
    int rows;
    int cols;
    Seat[][] grid;

    public Hall(int id, int rows, int cols, int premiumRows) {
        this.id = id;
        this.rows = rows;
        this.cols = cols;
        this.grid = new Seat[rows][cols];

        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
               grid[r][c] = new Seat(r, c, r < premiumRows);
            }
        }
    }

    Seat getSeat(int row, int col) {
        return grid[row][col];
    }

    int countAvailable() {
        int count = 0;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j].isAvailable()) {
                    count++;
                }
            }
        }
        return count;
    }

    void displayLayout() {
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                Seat s = grid[i][j];
                if(s.isAvailable())
                    System.out.println(".");
                if(s.isBooked())
                    System.out.println("#");
                if(s.isPremium())
                    System.out.println("*");
            }
        }
    }
}
