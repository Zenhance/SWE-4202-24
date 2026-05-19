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
        grid = new Seat[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                boolean isPremium = (i < premiumRows);
                grid[i][j] = new Seat(i,j,isPremium, false);
            }
        }
    }

    public Seat getSeat(int rows, int cols) {
        return grid[rows][cols];
    }

    public int countAvailable() {
        int cnt = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j].isAvailable())
                    cnt++;
            }
        }
        return cnt;
    }

    public void displayLayout() {


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Seat seat = grid[i][j];
                if (seat.isBooked()) {
                    System.out.print("#");
                } else if (seat.isPremium()) {
                    System.out.print("*");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }
}
