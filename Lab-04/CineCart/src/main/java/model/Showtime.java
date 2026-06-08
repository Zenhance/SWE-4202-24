package model;

public class Showtime {
    private final int id;
    private final Movie movie;
    private final Hall hall;
    private final int startHour;
    private final String dateTag;

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

    public Hall getHall() {
        return hall;
    }

    public int getStartHour() {
        return startHour;
    }

    public String getDateTag() {
        return dateTag;
    }



}



