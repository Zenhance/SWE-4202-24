public class Hall {
    private int id;
    private int rows;
    private int cols;
    private Seat[][] grid;

    private Hall(int id, int rows, int cols, int premiumRows) {
        this.id = id;
        this.rows = rows;
        this.cols = cols;
        this.grid = new Seat[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                grid[r][c] = new Seat(r + 1, c + 1, r < premiumRows);

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

    public Seat getSeat(int rows, int cols) {
        if (rows >= 1 && rows <= rows && cols >= 1 && cols<= cols) {
            return grid[rows - 1][cols - 1];
        }
        return null;
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
    public void displayLayout(){
        for (int r=0; r<rows; r++){
            for (int c=0; c<cols; c++){
                Seat seat= grid[r][c];
                if(seat.isBooked()){
                    System.out.println("#");
                }
                else if(seat.isPremium()){
                    System.out.println("*");
                }
                else {
                    System.out.println(".");
                }
            }
            System.out.println();
        }

}


}
