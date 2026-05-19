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

    public boolean isPeak() {
        if(startHour >= 18 && startHour <= 21)
            return true;
    }

    public String toString() {
        return String.format("[%d] %s @ Hall %d - %d (%s)", id, movie, hall, startHour, dateTag);
    }
}
