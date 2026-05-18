package model;

public class Showtime {
    private int id;
    private Movie movie;
    private int start;
    private int startHour;
    private String dateTag;

    public Showtime(int id, Movie movie, Hall hall, int startHour, String dateTag){
        this.id = id;
        this.movie = movie;
        this.start = start;
        this.startHour = startHour;
        this.dateTag = dateTag;
    }

    // getters
    public int getId() {
        return id;
    }

    public int getStart() {
        return start;
    }

    public int getStartHour() {
        return startHour;
    }

    public String getDateTag() {
        return dateTag;
    }

    public Movie getMovie() {
        return movie;
    }

    public boolean isPeak(){

    }
}
