package model;

import java.util.Arrays;

public class Hall {

    private int id;
    private int rows;
    private int cols;
    private Seat[][] grid;


    @Override
    public String toString() {
        return "Hall{" +
                "id=" + id +
                ", rows=" + rows +
                ", cols=" + cols +
                ", grid=" + Arrays.toString(grid) +
                '}';
    }

    public Hall (int id, int rows, int cols, int premiumRows) {

        this.id = id;
        this.rows = rows;
        this.cols = cols;
        this.grid = new Seat[rows][cols];


        for (int i = 0; i < rows; i++) {
            boolean premium = (rows < premiumRows);
            for (int j = 0; j < cols; j++) {
                grid[i][j] = new Seat(rows, cols, premium);
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
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j].isAvailable()) {
                    count++;
                }
            }
        }
        return count;
    }
}
