package model;

public class Showtime {
    private int id;
    private Movie movie;
    private Hall hall;
    private int startHour;
    private String datetag;

    public Showtime(int id, Movie movie, Hall hall, int startHour, String datetag) {
        this.id = id;
        this.movie = movie;
        this.hall = hall;
        this.startHour = startHour;
        this.datetag = datetag;
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

    public String getDatetag() {
        return datetag;
    }

    public boolean isPeak() {
        return startHour > 18 && startHour < 21;
    }

    public String toString() {
        return "[T"+id+"]"+movie.getTitle()+"@ Hall"+hall.getId()+"-"+startHour+"("+datetag+")";
    }
}