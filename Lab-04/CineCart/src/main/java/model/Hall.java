package model;

public class Hall {
    public int id;
    public int rows;
    public int cols;
    public Seat[][]grid;
    //constructor
    public Hall(int id, int rows, int cols, int premiumRows) {
        this.id = id;
        this.rows = rows;
        this.cols = cols;

        grid = new Seat[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                boolean premium = (r < premiumRows);
                grid[r][c] = new Seat(r, c, premium);
            }
        }
    }
    public int getId(){
    return id;
    }
    //methods
    public Seat getSeat(int row,int col){
        return grid[row][col];
    }
    int countAvailable() {
        int count = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c].isAvailable()) {
                    count++;
                }
            }
        }
        return count;
    }
        public void displayLayout() {
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    Seat seat = grid[r][c];
                    if (seat.isBooked) {
                        System.out.println("# ");
                    }
                    else if (seat.isPremium) {
                        System.out.println("* ");
                    }
                    else {
                        System.out.println(". ");
                    }
                }
                System.out.println();
            }
        }
        }