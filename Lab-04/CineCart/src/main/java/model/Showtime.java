package model;

public class Showtime {
    int id;
    Movie movie;
    Hall hall;
    int startHour;
    String dateTag;

    public Showtime(int id, Movie movie, Hall hall, int startHour, String dateTag) {
        this.id = id;
        this.movie = movie;
        this.hall = hall;
        this.startHour = startHour;
        this.dateTag = dateTag;
    }

    public int getId() {
        return id;
    }
    public Movie getMovie() {
        return movie;
    }
    public Hall hall() {
        return hall;
    }
    public int getStartHour() {
        return startHour;
    }
    public String getDateTag() {
        return dateTag;
    }
}
