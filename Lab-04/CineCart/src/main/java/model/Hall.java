package model;

public class Hall {
    int id;
    int rows;
    int cols;
    int premiumRows;

    public Hall(int id, int rows, int cols, int premiumRows) {
        this.id = id;
        this.rows = rows;
        this.cols = cols;
        this.premiumRows = premiumRows;
    }
}