package model;

public class Hall {

    private int hallId;
    private int rows;
    private int seatsPerRow;
    private int premiumRows;

    public Hall(int hallId, int rows, int seatsPerRow, int premiumRows) {
        this.hallId = hallId;
        this.rows = rows;
        this.seatsPerRow = seatsPerRow;
        this.premiumRows = premiumRows;
    }

    public int getHallId() {
        return hallId;
    }

    public int getRows() {
        return rows;
    }

    public int getSeatsPerRow() {
        return seatsPerRow;
    }

    public int getPremiumRows() {
        return premiumRows;
    }

    public void setHallId(int hallId) {
        this.hallId = hallId;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public void setSeatsPerRow(int seatsPerRow) {
        this.seatsPerRow = seatsPerRow;
    }

    public void setPremiumRows(int premiumRows) {
        this.premiumRows = premiumRows;
    }

    @Override
    public String toString() {
        return "Hall ID: " + hallId +
                ", Rows: " + rows +
                ", Seats Per Row: " + seatsPerRow +
                ", Premium Rows: " + premiumRows;
    }
}