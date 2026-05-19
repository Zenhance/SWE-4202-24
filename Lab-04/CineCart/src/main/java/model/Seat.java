package model;

public class Seat {
    int id;
    int col;
    boolean isPremium;
    boolean isBooked;

    public Seat(int id, int col, boolean isPremium, boolean isBooked) {
        this.id = id;
        this.col = col;
        this.isPremium = isPremium;
        this.isBooked = false;
    }


}
