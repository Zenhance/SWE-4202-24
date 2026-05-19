package model;

public class Showtime {
    // Fields: int id, Movie movie, Hall hall, int startHour (0–23), String dateTag.

    private int id;
    private Movie movie;
    private Hall hall;
    private int startHour;
    private String dateTag;


    //Constructor: full five-argument constructor.

    public Showtime(int id, Movie movie, Hall hall, int startHour, String dateTag) {
        this.id = id;
        this.movie = movie;
        this.hall = hall;
        this.startHour = startHour;
        this.dateTag = dateTag;
    }

    //Methods: getters; boolean isPeak() returning true when startHour is between 18 and 21 inclusive;

    public int getId() {
        return id;
    }

    public Movie getMovie() {
        return movie;
    }

    public Hall getHall() {
        return hall;
    }

    public int getStartHour() {
        return startHour;
    }

    public String getDateTag() {
        return dateTag;
    }


    //Methods: getters; boolean isPeak() returning true when startHour is between 18 and 21 inclusive;

    public boolean isPeak() {
        if (startHour >= 18 && startHour <=21 ) return true;
        return false;
    }


    //toString() e.g. "[T17] Inception @ Hall 2 - 19:00 (Fri)".

    public String toString() {
        return String.format("[T%d] %s @ Hall %d - %d:00 (%s)",id, movie.getTitle(), hall.getId(), startHour, dateTag);
    }

}
