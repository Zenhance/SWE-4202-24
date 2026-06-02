package model;

public class Hall {
    private int id;
    private int rows;
    private int cols;
    private Seat[][] grid;
    private int availCount = 0;

    public Hall(int id, int rows, int cols, int premiumRows){
        this.id = id;
        this.rows = rows;
        this.cols = cols;
        grid = new Seat[this.rows][this.cols];

        for (int r = 0; r < rows; r++ ) {
            for( int c = 0; c < cols; c++) {
                boolean isp = r < premiumRows;
                grid[r][c] = new Seat(r, c, isp);
            }
        }
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public Seat[][] getGrid() {
        return grid;
    }

    public int getAvailCount() {
        return availCount;
    }

    public int getId() {return id;}
    public Seat getSeat(int row, int col){return grid[row][col];}

    public int countAvailable(){
        availCount = 0;
        for (int r = 0; r < rows; r++ ) {
            for( int c = 0; c < cols; c++){
                if(grid[r][c].isAvailable())
                    availCount++;
            }
        }
        return availCount;
    }

    void displayLayout(){
        for (int r = 0; r < rows; r++ ) {
            for( int c = 0; c < cols; c++){
                Seat s = grid[r][c];
                if(s.isAvailable()) {
                    if(s.isPremium())
                        System.out.print("*");
                    else System.out.print(".");
                }
                else System.out.print("#");
            }
            System.out.println();
        }
    }
}