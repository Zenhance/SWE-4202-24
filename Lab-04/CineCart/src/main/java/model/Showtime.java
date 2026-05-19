package model;

public class Showtime {
    private int id;
    private Movie movie;
    private Hall hall;
    private int startHour;
    private String dateTag;

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

    public Hall getHall() {
        return hall;
    }

    public Movie getMovie() {
        return movie;
    }

    public String getDateTag() {
        return dateTag;
    }

    public int getStartHour() {
        return startHour;
    }

    public boolean isPeak() {
        boolean status = false;
        if (startHour >= 18 && startHour <= 21) status = true;

        return status;
    }

    public String toString() {
        return String.format("[T%d] %s @ Hall %d - %d:00 (%s)", id, movie.getTitle(), hall.getId(), startHour, dateTag);
    }
}