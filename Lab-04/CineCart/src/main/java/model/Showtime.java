package model;

public class Showtime {
    private int id;
    private Movie movie;
    private Hall hall;
    private int startHour;
    private String dateTag;

    public Showtime(int id, Movie movie, Hall hall, int startHour, String dateTag){
        this.id = id;
        this.movie = movie;
        this.hall = hall;
        this.startHour = startHour;
        this.dateTag = dateTag;
    }

    // getters
    public int getId() {
        return id;
    }

    public int getHall() {
        return hall;
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
        boolean res = false;
        if (startHour >= 18 && startHour <= 21){
            res = true;
        }
        return res;
    }

    public String toString() {
        return String.format("[T%d] %s @ Hall %d - %d:00 (%s)", id, movie.getTitle(), hall.getId(), startHour, dateTag);
    }
}
