package model;

public class Showtime {
    // Fields: int id, Movie movie, Hall hall, int startHour (0–23), String dateTag.

    public int id;
    public Movie movie;
    public Hall hall;
    public int startHour;
    public String dateTag;

    public Showtime(int id, Movie movie, Hall hall, int startHour, String dateTag) {
        this.id = id;
        this.movie = movie;
        this.hall = hall;
        this.startHour = startHour;
        this.dateTag = dateTag;
    }
    //Constructor: full five-argument constructor.
    //Methods: getters; boolean isPeak() returning true when startHour is between 18 and 21 inclusive;
    //toString() e.g. "[T17] Inception @ Hall 2 - 19:00 (Fri)".
}
