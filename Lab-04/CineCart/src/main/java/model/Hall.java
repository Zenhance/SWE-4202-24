package model;

public class Hall {
    private int id;
    private int rows;
    private int cols;
    private int premiumRows;

    public Hall(int id, int rows, int cols, int premiumRows) {
        this.id = id;
        this.rows = rows;
        this.cols = cols;
        this.premiumRows = premiumRows;
    }

    public int getId() {
        return id;
    }
}