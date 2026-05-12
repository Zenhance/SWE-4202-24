public class Seat {

    //fields
    private int row;
    private int col;
    private boolean isPremium;
    private boolean isBooked;

    //constructors
    public Seat(int row, int col, boolean isBooked, boolean isPremium) {

        this.row = row;
        this.col = col;
        this.isBooked = isBooked;
        this.isPremium;


    }

    //methods
    //getters
    public int getRow(int row) {
        return row;
    }

    public int getCol(int col) {
        return col;
    }

    public void book(boolean isBooked) {
        isBooked = true;
    }

    public void release(boolean isBooked) {
        isBooked = false;
    }

    public String toString(int row, int col) {
        System.out.println("R" + row + "C" + col);

        if (isPremium = true)
            System.out.println("*");
        if (isBooked = true)
            System.out.println("#");


    }

}