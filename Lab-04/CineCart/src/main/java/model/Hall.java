package model;

public class Hall {

    //fields
    private int id;
    private int rows;
    private int cols;
    private int Seat[][];


    //constructors
    public Hall(int id, int rows, int cols, int premiumRows) {

        this.id = id;
        this.rows = rows;
        this.cols = cols;
    }

    //methods
    public Seat getSeat(int row, int col) {

    }

    public int countAvailable() {

    }

    public void displayLayout() {

    }
}