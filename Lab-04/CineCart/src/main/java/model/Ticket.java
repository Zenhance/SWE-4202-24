package model;

public abstract class Ticket {


    //fields
    Showtime showtime;
    int row;
    int col;
    double basePrice;
    double peak = 1.20;

    //constructor
    public Ticket(Showtime showtime, int row, int col, double basePrice) {

    }

    public abstract double getCharge();


}