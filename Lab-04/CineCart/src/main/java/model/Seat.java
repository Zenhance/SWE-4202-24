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
        this.isBooked = false;
        this.isPremium;


    }

    //methods
    //getters
    public int getRow() {

        return this.row;
    }

    public int getCol() {

        return col;
    }

    public void book() {

        this.isBooked = true;
    }

    public void release(boolean isBooked) {
        isBooked = false;
    }

    public String toString() {
        String seat = "R" + row + "C" + col;

        if (isPremium = true) {
            return s + "*";
        }


        if (isBooked = true)
            return s + "#";
    }

}